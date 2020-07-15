echo "this is pre-stop" >> /data/destroy.hook
pid=$(ps -ef | grep java | grep -v '/bin/sh' | grep -v grep | awk '{print $2}')
echo $pid
kill $pid
sleep 1

