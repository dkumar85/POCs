import React, { Component } from "react";
import { Container, Row, Col, Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import "./Signin.css";
import { consumePostUrl } from "../Utils/CommonUtils.js";

class Signin extends Component {
  constructor(props) {
    super(props);

    this.state = {
      isDisabled: true,
      email: "",
      emailError: true,
      password: "",
      passwordError: true,
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
      this.state.passwordError === false
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
    consumePostUrl("signin", body).then(response => {
      if (response.status === 200) {
        this.setState({ userDetails: response.data.data });
        window.alert(response.data.message);
        window.open("/about", "_self");
      } else {
        window.alert(response.response.data.message); //important
      }
    });
  }

  logFields = () => {
    const { email, password, rememberMe } = this.state;
    console.log(
      "Email: ",
      `${email}`,
      "Password: ",
      `${password}`,
      "Remember Me: ",
      `${rememberMe}`
    );
  };

  componentDidMount() {
      /*
    consumeGetUrl("test").then(response => {
      this.setState({ test: response.data });
      console.log(response);
    });
    */
  }

  render() {
    const { email, password, isDisabled } = this.state;
    return (
      <Container className="signin">
        <Form onSubmit={this.handleSubmit}>
          <Row className="justify-content-center">
            <Col xs={12} sm={8} lg={6}>
              <Form.Group controlId="formBasicEmail" className="group">
                <Form.Label>Email address</Form.Label>
                <Form.Control
                  type="email"
                  placeholder="Enter email"
                  name="email"
                  value={email}
                  onChange={this.handleChange}
                />
              </Form.Group>
              <Form.Group controlId="formBasicPassword" className="group">
                <Form.Label>Password</Form.Label>
                <Form.Label
                className="float-right"
                >
                <a href="/signup">Forgot password</a>
                </Form.Label>
                <Form.Control
                  type="password"
                  placeholder="Password"
                  name="password"
                  value={password}
                  onChange={this.handleChange}
                />
              </Form.Group>

              <Form.Group controlId="formBasicCheckbox" className="group">
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
               Sign In 
              </Button>
                <Form.Label
                className="float-right"
                >New User?<a href="/signup"> Sign Up</a></Form.Label>

            </Col>
          </Row>
        </Form>
      </Container>
    );
  }
}

export default Signin;
