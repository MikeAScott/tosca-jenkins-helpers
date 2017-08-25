def call(){
  def configFileName = "${env.WORKSPACE}/TestConfig.xml"
  bat "\"..\\CIClient\\ToscaCIClient.exe -m distributed -r results.xml -t junit -c ${configFileName}\""
}