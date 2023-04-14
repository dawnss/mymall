#!/bin/bash

# 请注意
# 本脚本的作用是把本项目编译的结果保存到deploy文件夹中
# 1. 把项目数据库文件拷贝到docker/db/init-sql
# 2. 编译mymall-admin
# 3. 编译mymall-all模块，然后拷贝到docker/mymall

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"
cd $DIR/../..
LITEMALL_HOME=$PWD
echo "LITEMALL_HOME $LITEMALL_HOME"

# 复制数据库
cat $LITEMALL_HOME/mymall-db/sql/mymall_schema.sql > $LITEMALL_HOME/docker/db/init-sql/mymall.sql
cat $LITEMALL_HOME/mymall-db/sql/mymall_table.sql >> $LITEMALL_HOME/docker/db/init-sql/mymall.sql
cat $LITEMALL_HOME/mymall-db/sql/mymall_data.sql >> $LITEMALL_HOME/docker/db/init-sql/mymall.sql

# 安装阿里node镜像工具
npm install -g cnpm --registry=https://registry.npm.taobao.org

# 打包mymall-admin
cd $LITEMALL_HOME/mymall-admin
cnpm install
cnpm run build:dep

# 打包mymall-vue
cd $LITEMALL_HOME/mymall-vue
cnpm install
cnpm run build:dep

cd $LITEMALL_HOME
mvn clean package
cp -f $LITEMALL_HOME/mymall-all/target/mymall-all-*-exec.jar $LITEMALL_HOME/docker/mymall/mymall.jar