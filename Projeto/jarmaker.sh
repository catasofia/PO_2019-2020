if [ $# -eq 1 ];then
	exit(1)
fi
jar -c -f $* `find m19 -name "*.java"`
