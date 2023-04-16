#!/bin/bash

# 本脚本的作用是停止当前Spring Boot应用，然后再次部署
PID=$(ps -ef | grep mymall.jar | grep -v grep | awk '{ print $2 }')

if [ ! -z "$PID" ]
then
    kill $PID
fi

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"
cd $DIR/..
#项目根目录
MYMALL_HOME=$PWD
echo "MYMALL_HOME $MYMALL_HOME"

cd $MYMALL_HOME/mymall || exit 2
nohup java -jar mymall.jar > log.log 2>&1 &