if [ $# -eq 0 ];then
	exit 1;
fi
jar -cf "$1" `find m19 -name "*.java"`
