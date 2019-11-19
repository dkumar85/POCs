import React, { Component } from "react";
import { Navbar, Nav } from "react-bootstrap";

export class CustomNavBar extends Component {
  render() {
    return (
      <Navbar bg="dark" variant="dark" expand="lg" fixed="top">
        <Navbar.Brand href="/">EU DevOps</Navbar.Brand>
        <Navbar.Toggle />
        <Navbar.Collapse id="basic-navbar-nav" className="justify-content-start">
          <Nav>
            <Nav.Link href="/">Home</Nav.Link>
            <Nav.Link href="/about">About</Nav.Link>
          </Nav>
        </Navbar.Collapse>
        <Navbar.Collapse id="basic-navbar-nav2" className="justify-content-end">
          <Nav>
            <Nav.Link href="/profile">Profile</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Navbar>
    );
  }
}

export default CustomNavBar;
