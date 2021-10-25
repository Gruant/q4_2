select s.date,
       m.name as movie1,
       s.start,
       s.duration,
       s.stop,
       table1.name as movie2,
       table1.start,
       table1.duration,
       table1.stop
from session as s
         join movie as m on s.movie_id = m.id
         join (select s.date, m.name, s.start, s.duration, s.stop
               from session as s
                        join movie as m on s.movie_id = m.id
               order by date, start) as table1
where s.date = table1.date
  and table1.start < s.stop
  and s.start < table1.start
order by s.date, s.start;