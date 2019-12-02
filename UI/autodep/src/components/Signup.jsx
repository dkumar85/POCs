import React, { Component } from "react";
import { Container, Row, Col, Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import "./Signup.css";
import { consumePostUrl} from "../Utils/CommonUtils.js";


class Signup extends Component {
  constructor(props) {
    super(props);

    this.state = {
      isDisabled: true,
      email: "",
      emailError: true,
      password: "",
      passwordError: true,
      question: "question-1",
      answer: "",
      answerError: true,
      rememberMe: false
    };

    this.handleChange = this.handleChange.bind(this);
    this.enableSubmit = this.enableSubmit.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.logFields = this.logFields.bind(this);
  }

  /*
  This method is invoked on each keypress inside any form field.
  It sets the state of component and value of the form fields.
  It also sets all the flags that are needed to evaluate the condition to
  enable submit button.
  */
  handleChange(e) {
    const target = e.target;
    const value = target.type === "checkbox" ? target.checked : target.value;
    const name = target.name;
    this.setState({ [name]: value });

    switch (name) {
      case "email":
        if (value === "" || value === null) {
          this.setState({ emailError: true });
        } else {
          this.setState({
            emailError: false
          });
        }
        break;

      case "password":
        if (value === "" || value === null) {
          this.setState({ passwordError: true });
        } else {
          this.setState({
            passwordError: false
          });
        }
        break;

      case "answer":
        if (value === "" || value === null) {
          this.setState({ answerError: true });
        } else {
          this.setState({
            answerError: false
          });
        }
        break;

      default:
    }

    this.setState({}, () => {
      this.enableSubmit();
    });
  }

  /*
  This methods enables the submit button only when all the form fields have 
  some input value.
  */
  enableSubmit() {
    if (
      this.state.emailError === false &&
      this.state.passwordError === false &&
      this.state.answerError === false
    ) {
      this.setState({ isDisabled: false });
    }
  }

  /*
  This method is invoked when user clicks submit button. It does following things:
  1. Prints values of various form fields on console.
  2. Validate values of input fields such as validity of email.
  3. Checks email id is already registered or not
  4. Finally, registers this user with database
  */
  handleSubmit(e) {
    e.preventDefault();

    const body = {
      email: this.state.email.toLowerCase(),
      password: this.state.password,
      question: this.state.question,
      answer: this.state.answer,
      rememberMe: this.state.rememberMe
    };

    //Email validation
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (!(body.email.match(mailformat))) {
      window.alert("Invalid email format. Please correct it.");
      return;
    } 

    //Password validation
    if (body.password.length < 6) {
      window.alert("Password length cannot be less than 6.");
      return;
    }

    //Sending post request to register user
    consumePostUrl("signup", body).then(response => {
      if (response.status === 200) {
        this.setState({ userDetails: response.data.data });
        window.alert(response.data.message);
        window.open("/signin", "_self");
      } else {
        window.alert(response.response.data.message); //important
      }
    });
  }

  logFields = () => {
    const { email, password, answer, rememberMe } = this.state;
    console.log(
      "Email: ",
      `${email}`,
      "Password: ",
      `${password}`,
      "Answer: ",
      `${answer}`,
      "Remember Me: ",
      `${rememberMe}`
    );
  };


  render() {
    const { email, password, question, answer, isDisabled } = this.state;
    return (
      <Container className="signup">
        <Form onSubmit={this.handleSubmit}>
          <Row className="justify-content-center">
            <Col xs={12} sm={8} lg={4}>
              <div className="divCenter">
              <Form.Group controlId="formBasicEmail" className="groupCustom">
                <Form.Label>Email address</Form.Label>
                <Form.Control
                  type="email"
                  placeholder="Enter email"
                  name="email"
                  value={email}
                  onChange={this.handleChange}
                />
              </Form.Group>
              <Form.Group controlId="formBasicPassword" className="groupCustom">
                <Form.Label>Password</Form.Label>
                <Form.Control
                  type="password"
                  placeholder="Password"
                  name="password"
                  value={password}
                  onChange={this.handleChange}
                />
                <Form.Text className="text-muted">
                  Minimun length of the password should be 6 characters.
                </Form.Text>
              </Form.Group>

              <Form.Group controlId="securityQuestion" className="groupCustom">
                <Form.Label> Select your security question</Form.Label>
                <select
                  className="selectlable"
                  value={question}
                  name="question"
                  onChange={this.handleChange}
                >
                  <option value="question-1">
                    What is your favorite book?
                  </option>
                  <option value="question-2">What is your pin code?</option>
                  <option value="question-3">What is name of your pet?</option>
                </select>
                <Form.Control
                  type="text"
                  placeholder="Enter answer"
                  name="answer"
                  value={answer}
                  onChange={this.handleChange}
                />
              </Form.Group>

              <Form.Group controlId="formBasicCheckbox" className="groupCustom">
                <Form.Check
                  type="checkbox"
                  label="Remember me"
                  name="rememberMe"
                  onChange={this.handleChange}
                />
              </Form.Group>
              <Button 
              variant="primary"
              type="submit"
              disabled={isDisabled}
             size="lg" block
             className="submitButton"
              >
                Submit
              </Button>

              <Form.Label
                className="float-right"
                >
                New User?
                <a href="/signin"> Sign In</a>
                </Form.Label>
              </div>
            </Col>
          </Row>
        </Form>
      </Container>
    );
  }
}

export default Signup;
