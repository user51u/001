INSERT INTO public.t_role(id, name)
  VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');


  INSERT INTO public.t_status_workplace(id, name)
    VALUES (1, 'занято'), (2, 'свободно'), (3, 'выбрано'), (4, 'недоступно');

--    тест

-- 12345678

SELECT * FROM public.t_workplace_bron
where
date_start2 > '2021-08-10 09:15:00' and date_start2 < '2021-08-10 15:45:00'
or
date_stop > '2021-08-10 09:15:00' and date_stop < '2021-08-10 15:45:00'
ORDER BY id ASC



SELECT * FROM public.t_workplace_bron
where number = 41
ORDER BY id ASC