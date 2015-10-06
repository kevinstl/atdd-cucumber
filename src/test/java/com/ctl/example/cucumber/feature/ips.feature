@CLC_IPS
Feature:  CLC_IPS - Install

@CLC_IPS_INSTALL
Scenario: IPS for Linux
Given a Centurylink customer has a server
When IPS is installed on that server
Then the server is protected with IPS