import React, { Component } from "react";
import { CustomNavBar } from "./CustomNavBar"; // concept: {} are used for custom export
import Nav from "react-bootstrap/Nav";
import {
  Container,
  Row,
  Col,
  Card,
  ListGroup,
  Button,
  CardColumns,
  Table,
  Form,
  Dropdown
} from "react-bootstrap";
import "./Home.css";

class Home extends Component {
  render() {
    return (
      <div>
        <div>
          <CustomNavBar />
        </div>
        <div className="leftPane">
          <Nav variant="tabs" defaultActiveKey="/" className="flex-column">
            <Nav.Link className="navLink" href="/">
              Home
            </Nav.Link>
            <Nav.Link className="navLink" href="/about">
              About
            </Nav.Link>
            <Nav.Link className="navLink" eventKey="link-2">
              Link
            </Nav.Link>
            <Nav.Link className="navLink" eventKey="disabled" disabled>
              Disabled
            </Nav.Link>
          </Nav>
        </div>
        <div className="rightPane">
          <Container className="containerHomePage">
            <Row>
              <Col>
                <Card>
                  <Card.Header as="h5">Your Jira Tickets</Card.Header>
                  <Card.Body>
                    <Table
                      striped
                      bordered
                      hover
                      size="sm"
                      responsive="sm"
                      style={{
                        textAlign: "center"
                      }}
                    >
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>Key</th>
                          <th>Summary</th>
                          <th>Assignee</th>
                          <th>Status</th>
                          <th>Language</th>
                          <th>Components</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>
                            <Form.Group
                              controlId="formBasicCheckbox"
                              className="groupCustom"
                            >
                              <Form.Check type="checkbox" />
                            </Form.Group>
                          </td>
                          <td>
                            <a href="https://mics.samsungmobile.com/browse/BIDII-1329">
                              BIDII-1329
                            </a>
                          </td>
                          <td>
                            BIDII-12 CLONE - [Step-2] Bixby 2.0 ASR it-IT
                            Integration Request DEV-INT Farm
                          </td>
                          <td>EU Devops Team</td>
                          <td>Open</td>
                          <td>it-IT</td>
                          <td>ASR</td>
                        </tr>
                        <tr>
                          <td>
                            <Form.Group
                              controlId="formBasicCheckbox"
                              className="groupCustom"
                            >
                              <Form.Check type="checkbox" />
                            </Form.Group>
                          </td>
                          <td>
                            <a href="https://mics.samsungmobile.com/browse/BIDII-1329">
                              BIDII-1329
                            </a>
                          </td>
                          <td>
                            BIDII-12 CLONE - [Step-2] Bixby 2.0 ASR it-IT
                            Integration Request DEV-INT Farm
                          </td>
                          <td>EU Devops Team</td>
                          <td>Open</td>
                          <td>it-IT</td>
                          <td>ASR</td>
                        </tr>
                        <tr>
                          <td>
                            <Form.Group
                              controlId="formBasicCheckbox"
                              className="groupCustom"
                            >
                              <Form.Check type="checkbox" />
                            </Form.Group>
                          </td>
                          <td>
                            <a href="https://mics.samsungmobile.com/browse/BIDII-1329">
                              BIDII-1329
                            </a>
                          </td>
                          <td>
                            BIDII-12 CLONE - [Step-2] Bixby 2.0 ASR it-IT
                            Integration Request DEV-INT Farm
                          </td>
                          <td>EU Devops Team</td>
                          <td>Open</td>
                          <td>it-IT</td>
                          <td>ASR</td>
                        </tr>
                        <tr>
                          <td>
                            <Form.Group
                              controlId="formBasicCheckbox"
                              className="groupCustom"
                            >
                              <Form.Check type="checkbox" />
                            </Form.Group>
                          </td>
                          <td>
                            <a href="https://mics.samsungmobile.com/browse/BIDII-1329">
                              BIDII-1329
                            </a>
                          </td>
                          <td>
                            BIDII-12 CLONE - [Step-2] Bixby 2.0 ASR it-IT
                            Integration Request DEV-INT Farm
                          </td>
                          <td>EU Devops Team</td>
                          <td>Open</td>
                          <td>it-IT</td>
                          <td>ASR</td>
                        </tr>
                      </tbody>
                    </Table>
                    <Dropdown>
                      <Dropdown.Toggle variant="success" id="dropdown-basic">
                       Deploy 
                      </Dropdown.Toggle>

                      <Dropdown.Menu>
                        <Dropdown.Item href="#/action-1">INT</Dropdown.Item>
                        <Dropdown.Item href="#/action-2">STG</Dropdown.Item>
                        <Dropdown.Item href="#/action-3">PROD</Dropdown.Item>
                      </Dropdown.Menu>
                    </Dropdown>
                  </Card.Body>
                </Card>
              </Col>
            </Row>
          </Container>
        </div>
      </div>
    );
  }
}

export default Home;
