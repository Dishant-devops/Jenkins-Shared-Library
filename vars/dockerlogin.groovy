def call (String credentialsid , String dockerhub_username , String image_name, String image_tag ) {
     withCredentials([usernamePassword
     (credentialsId: "${DOCKER_CREDENTIAL_ID}", 
      usernameVariable: 'DOCKER_USERNAME',
      passwordVariable: 'DOCKER_PASSWORD')]) {
      sh """ echo $DOCKER_PASSWORD |docker login -u $DOCKER_USERNAME --password-stdin
              docker push ${DOCKERHUB_USERNAME}/${IMAGE_NAME}:${IMAGE_TAG}
         """
}
}
