#!/bin/bash
function compile(){
  javac -cp po-uilib.jar:. `find m19 -name "*.java"`;
  if [ $# -eq 0 ];then
    java -cp po-uilib.jar:. -Dimport=tests/ImportGiant.import m19.app.App;
  else
    java -cp po-uilib.jar:. -Dimport="$1" m19.app.App;
  fi

  rm -rf `find m19 -name "*.class"`;
}

function jarM(){
  if [ ! $# -eq 0 ];then 
    jar -cf "$1" `find m19 -name "*.java"`;
  fi
}

alias run="./runjavac.sh";
