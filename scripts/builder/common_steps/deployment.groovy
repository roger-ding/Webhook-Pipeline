def deploymentStack() {
  timestamps {
    stage('Setup') {
      sh "mkdir -p deploy"
    }

    stage('DEV') {
      echo 'Hello World 123'
      sh "python ${BUILD_WORKSPACE}@script/test/wait.py"
    }

    stage 'QA'
    echo 'Hello World 22'
    
    stage 'PRODUCTION'
    echo 'Hello World 3'
  }
  //stage 'Archive and Fingerprint'
  //sh "tar -czf ${env.BUILD_WORKSPACE}/${env.BUILD_DISPLAY_NAME}.tar.gz " +
  //        "--exclude=./${env.BUILD_DISPLAY_NAME}.tar.gz -C ${env.JENKINS_HOME} ."
  //archiveArtifacts artifacts: "*.tar.gz", fingerprint: true
}

return this

