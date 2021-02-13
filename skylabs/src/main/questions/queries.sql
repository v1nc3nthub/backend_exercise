-- query 1
select count(*) from records where age < 30 and over_50k = 1;
-- query 2
select w.name, (sum(r.capital_gain) - sum(r.capital_loss))/count(*) as capital_average
from records r
join workclasses w on w.id = r.workclass_id
group by w.name
order by capital_average asc;