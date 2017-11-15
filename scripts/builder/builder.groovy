/*
  This file provides the main interface for the creation of a cluster
  It abstracts the main phases and delegates to external files the definition
  of actions that are specific to the type of cluster
*/

def buildAgent() {
  println "*** Starting build ***"

  try {
    def deploy_steps = load "${BUILDER_DIR}/common_steps/deployment.groovy"
    deploy_steps.deploymentStack()
  } catch (hudson.AbortException ex) {
    if (ex.getMessage() == "script returned exit code 143") {
      currentBuild.result = "ABORTED"
    } else {
      currentBuild.result = "FAILURE"
    }
    println ex
  } catch (ex) {
    currentBuild.result = "FAILURE"
    println ex
  } finally {
    /* DO SOMETHING HERE!!! */
  }
}

return this
