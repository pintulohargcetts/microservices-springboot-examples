#!/bin/bash
# ex.retrieve user detail |
curl -i host.docker.internal:9091/users/123 ; echo -e "(microservice-A)\n-----------"

# ex.retrieve chat list
curl -i host.docker.internal:9092/chat/123 ; echo -e "(microservice-B)\n-----------"

# ex.retrieve call list
curl -i host.docker.internal:9093/call/123 ; echo -e "(microservice-C)\n-----------"




