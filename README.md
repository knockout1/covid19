# COVID19 backend app
###Endpoints:
* /statistics/getDailyStats/{date} - get daily statistics, date format = dd-MM-yyyy
* /statistics/forceUpdate - get statistics (update all)

###TODO:
* save db copy during forceUpdate
* save db date instead of datetime
* cron update
* date as primary key?
