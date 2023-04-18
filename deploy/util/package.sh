#!/bin/bash

# 请注意
# 本脚本的作用是把本项目编译的结果保存到deploy文件夹中
# 1. 把项目数据库文件拷贝到deploy/db
# 2. 编译mymall-admin
# 3. 编译mymall-all模块，然后拷贝到deploy/mymall

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"
cd $DIR/../..
#项目根目录
MYMALL_HOME=$PWD
echo "MYMALL_HOME $MYMALL_HOME"

# 复制数据库
cat $MYMALL_HOME/mymall-db/sql/mymall_schema.sql > $MYMALL_HOME/deploy/db/mymall.sql
cat $MYMALL_HOME/mymall-db/sql/mymall_table.sql >> $MYMALL_HOME/deploy/db/mymall.sql
cat $MYMALL_HOME/mymall-db/sql/mymall_data.sql >> $MYMALL_HOME/deploy/db/mymall.sql

# 安装阿里node镜像工具
npm config set registry https://registry.npm.taobao.org

# 打包mymall-admin
echo "=====编译打包mymall-admin====="
cd $MYMALL_HOME/mymall-admin
npm install
npm run build:dep

# 打包mymall-vue
echo "=====编译打包mymall-vue====="
cd $MYMALL_HOME/mymall-vue
npm install
npm run build:dep

echo "=====编译打包java代码====="
cd $MYMALL_HOME
mvn clean package
cp -f $MYMALL_HOME/mymall-all/target/mymall-all-*-exec.jar $MYMALL_HOME/deploy/mymall/mymall.jar

# 单独复制到一个目录下
cd ../
PARENT_HOME=$PWD
mkdir -p project
cd $PARENT_HOME/project

echo "=====停止原来服务====="
PID=$(ps -ef | grep mymall.jar | grep -v grep | awk '{ print $2 }')

if [ ! -z "$PID" ]
then
    kill $PID
fi


echo "=====启动脚本、代码复制到指定路径====="
cp -rf $MYMALL_HOME/deploy/bin $PARENT_HOME/project

chmod +x ./bin/*.sh
cp -rf $MYMALL_HOME/deploy/mymall $PARENT_HOME/project
echo "=====项目打包编译完成====="