
Feature: Basic Test

Scenario: openmain window
 Given I have 25 cukes in my belly
 When open "www.michaelslab.net"
 When find "a name"
 Then the answer is 25
