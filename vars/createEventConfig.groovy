import groovy.xml.XmlUtil

def call(String testEvent) {

  def configFormat = '''<?xml version="1.0" encoding="utf-16" ?>

<testConfiguration>

  <TestEvents>

    <TestEvent />

  </TestEvents>

</testConfiguration>

'''
  def fileName = "${env.WORKSPACE}/TestConfig.xml"
  echo "Creating Config File: ${fileName}"

  def xml = new XmlParser().parseText(configFormat)

  xml.TestEvents.TestEvent[0].value = testEvent
 
  def writer = new FileWriter(fileName) 

  new XmlUtil().serialize(xml,writer)
 
  writer.close()
}

