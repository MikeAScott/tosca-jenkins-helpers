def configFormat = '''<?xml version="1.0" encoding="utf-16" ?>

<testConfiguration>

  <TestEvents>

    <TestEvent />

  </TestEvents>

</testConfiguration>

'''

String createConfigFile(String testEvent) {
  def fileName = "${env.WORKSPACE}/TestConfig.xml"
  echo "Creating Config File: ${fileName}"

  def xml = new XmlParser().parseText(configFormat)

  xml.TestEvents.TestEvent[0].value = testEvent
 
  def writer = new FileWriter(fileName) 

  new XmlUtil().serialize(xml,writer)
 
  writer.close()
  return fileName
}
