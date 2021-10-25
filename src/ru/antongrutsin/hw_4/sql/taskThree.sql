select (case
            when s.start between '09:00:00' and '14:59:59' then '09:00:00-14:59:59'
            else
                (case
                     when s.start between '15:00:00' and '17:59:59' then '15:00:00-17:59:59'
                     else
                         (case
                              when s.start between '18:00:00' and '20:59:59' then '18:00:00-20:59:59'
                              else
                                  (case
                                       when s.start between '21:00:00' and '23:59:59' then '21:00:00-23:59:59'
                                       else 0 end)
                             end)
                    end)
    end)                           as period,
       sum(quantity)               as qua_sum,
       sum(cost * quantity) as tickets_cost_sum
from session as s
         join ticket as t on t.session_id = s.id
group by period;