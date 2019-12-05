#!/bin/bash

NUM=0
SUC=0
FAIL=0
javac -cp po-uilib.jar:. `find m19 -name "*.java"`
#java -cp po-uilib.jar:. m19.app.App

#rm -rf `find m19 -name "*.class"`
for x in tests/*.in; do
    NUM=$[$NUM+1]
    printf "\033[01;36m%s -- " $x
    if [ -e ${x%.in}.import ]; then
        java -cp :po-uilib.jar:. -Dimport=${x%.in}.import -Din=$x -Dout=${x%.in}.outhyp m19.app.App;
    else
        java -cp po-uilib.jar:. -Din=$x -Dout=${x%.in}.outhyp m19.app.App;
    fi
    diff -cB -w ${x%.in}.out ${x%.in}.outhyp > ${x%.in}.diff ;
    if [ -s ${x%.in}.diff ]; then
        echo -en "\033[01;31mFAIL: $x. See file ${x%.in}.diff" "\n"
	if [ ! $# -eq 0 ];then
		xdg-open ${x%.in}.diff
	fi
	FAIL=$[$FAIL+1];
    else
	echo -en "\033[01;32mSUCCESS" "\n"
        rm -f ${x%.in}.diff ${x%.in}.outhyp
	SUC=$[$SUC+1];
    fi

done

rm -f saved*

echo -en "\033[01;32mSUCCESS: " $SUC "of " $NUM " test" "\n"
echo -en "\e[5m"
echo -en "\033[01;31mFAIL: " $FAIL "of " $NUM " test" "\n"
echo -en "\e[0m"
printf "           \033[01;33m%d" $((100*$SUC/$NUM))
echo "%"

find . -name '*.class' -exec rm -f {} \;
