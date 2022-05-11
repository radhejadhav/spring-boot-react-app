import React from 'react'
import { Button, Card, CardBody, Col, Container, FormFeedback, FormGroup, Input, Label, Row } from 'reactstrap'
import { REGISTER } from '../shared/RouterConstant'
export default function LoginComponent(props) {
    return (
        <Container>
            <Row>
                <Col className="my-4" md={{ offset: 3, size: 6 }} sm="12">
                    <Card inverse
                        body
                        style={{
                            backgroundColor: '#2F4F4F',
                            borderColor: '#333',
                            width: '500px',
                            fontFamily:'MV Boli'
                        }}>
                        <h2 style={{color:'#6B8E23', marginBlock:'-15px', textAlign:'end', fontFamily:'Impact'}}>Please Login</h2>
                        <hr style={{backgroundColor:'#7CFC00'}}/>
                        <CardBody style={{marginTop:'-30px'}}>
                            <FormGroup>
                                <Label>Username</Label>
                                <Input name='username' type='text' value={props.state.username} onChange={e => props.onChangeHandler(e)} invalid={(props.state.usernameError !== "")} />
                                <FormFeedback>{props.state.usernameError}</FormFeedback>
                            </FormGroup>
                            <FormGroup>
                                <Label>Password</Label>
                                <Input name='password' type='password' value={props.state.password} onChange={e => props.onChangeHandler(e)} invalid={(props.state.passwordError !== "")} />
                                <FormFeedback>{props.state.passwordError}</FormFeedback>
                            </FormGroup>
                            <FormGroup>
                                Not an account ? <a href={REGISTER}>Create Here..!</a><br />
                            </FormGroup>
                            <Button onClick={props.onSubmitHandler} type='button'>Submit</Button>
                        </CardBody>
                    </Card>
                </Col>
            </Row>
        </Container>
    )
}