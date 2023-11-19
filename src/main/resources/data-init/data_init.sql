insert into roles(id, role_name)
VALUES (1, 'Admin'),
       (2, 'Customer');

insert into users(id, address, email, first_name, image, last_name, password, phone_number, role_id)
VALUES (1, 'Арча Бешик 23', 'nurislam@gmail.com', 'Nurislam',
        'https://t3.ftcdn.net/jpg/05/16/27/58/360_F_516275801_f3Fsp17x6HQK0xQgDQEELoTuERO4SsWV.jpg', 'Mamytov',
        '$2a$12$j48u7W0s8v0DBjuE7qY/hOJfe/ivaMQXzFmGkrUHwnWL3s9vGnhRq', '+996999219743', 1),
       (2, 'Манаса 2б', 'syimyk@gmail.com', 'Syimyk',
        'https://t3.ftcdn.net/jpg/05/16/27/58/360_F_516275801_f3Fsp17x6HQK0xQgDQEELoTuERO4SsWV.jpg', 'Ravshanbekov',
        '$2a$12$j48u7W0s8v0DBjuE7qY/hOJfe/ivaMQXzFmGkrUHwnWL3s9vGnhRq', '+996222219743', 2),
       (3, 'Горький 67', 'ulukbekkochkorov@gmail.com', 'Ulukbek',
        'https://ca.slack-edge.com/T023L1WBFLH-U039MSMK57X-4929313a09a1-512', 'Kochkorov',
        '$2a$12$j48u7W0s8v0DBjuE7qY/hOJfe/ivaMQXzFmGkrUHwnWL3s9vGnhRq', '+996777219743', 2),
       (4, 'Кара Балта', 'mirgul@gmail.com', 'Mirgul',
        'https://t3.ftcdn.net/jpg/05/16/27/58/360_F_516275801_f3Fsp17x6HQK0xQgDQEELoTuERO4SsWV.jpg', 'Abdinazarova',
        '$2a$12$j48u7W0s8v0DBjuE7qY/hOJfe/ivaMQXzFmGkrUHwnWL3s9vGnhRq', '+996778219743', 2),
       (5, 'Восток 5', 'baktygul@gmail.com', 'Baktygul',
        'https://ca.slack-edge.com/T023L1WBFLH-U03MZ5ZUUTV-92902693f1ad-512', 'Kushtarbek kyzy',
        '$2a$12$j48u7W0s8v0DBjuE7qY/hOJfe/ivaMQXzFmGkrUHwnWL3s9vGnhRq', '+996778219743', 2),
       (6, 'Чуй 30', 'nursultan@gmail.com', 'Nursultan',
        'https://ca.slack-edge.com/T023L1WBFLH-U03N11XCKA6-e1c7667fa3fa-512', 'Zhumataev',
        '$2a$12$j48u7W0s8v0DBjuE7qY/hOJfe/ivaMQXzFmGkrUHwnWL3s9vGnhRq', '+996778219743', 2);

insert into users(id, address, email, first_name, image, last_name, password, phone_number, role_id)
VALUES (7, 'Арча Бешик 23', 'alisher@gmail.com', 'Alisher',
        'https://ca.slack-edge.com/T023L1WBFLH-U024NTSN7A9-58ce1a0108ef-512', 'Zhumanov',
        '$2a$12$j48u7W0s8v0DBjuE7qY/hOJfe/ivaMQXzFmGkrUHwnWL3s9vGnhRq', '+996999219743', 2),
       (8, 'Манаса 2б', 'albina@gmail.com', 'Albina',
        'https://ca.slack-edge.com/T023L1WBFLH-U03MU256DDF-9943b3a9aa01-512', 'Azamatova',
        '$2a$12$j48u7W0s8v0DBjuE7qY/hOJfe/ivaMQXzFmGkrUHwnWL3s9vGnhRq', '+996222219743', 2),
       (9, 'Горький 67', 'malik@gmail.com', 'Malik',
        'https://t3.ftcdn.net/jpg/05/16/27/58/360_F_516275801_f3Fsp17x6HQK0xQgDQEELoTuERO4SsWV.jpg', 'Kaamilov',
        '$2a$12$j48u7W0s8v0DBjuE7qY/hOJfe/ivaMQXzFmGkrUHwnWL3s9vGnhRq', '+996777219743', 2),
       (10, 'Кара Балта', 'nurtilek@gmail.com', 'Nurtilek',
        'https://ca.slack-edge.com/T023L1WBFLH-U03LMNBD4RK-37804c461201-512', 'Maksatbek uulu',
        '$2a$12$j48u7W0s8v0DBjuE7qY/hOJfe/ivaMQXzFmGkrUHwnWL3s9vGnhRq', '+996778219743', 2);

insert into brands(id, brand_name, image)
VALUES (1, 'Apple',
        'https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/976px-Apple_logo_black.svg.png?20220821121934'),
       (2, 'Samsung',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjORvDnwy5Mm0oAz8NItWzuql0JTMkjmu-wQ&usqp=CAU'),
       (3, 'Xiaomi', 'https://www.ixbt.com/short/images/2017/Oct/logo-xiaomi.jpg'),
       (4, 'Acer',
        'https://static.vecteezy.com/system/resources/previews/016/680/500/original/acer-logo-editorial-logo-free-vector.jpg'),
       (5, 'Asus',
        'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAASwAAACoCAMAAABt9SM9AAAAgVBMVEX///8AAAChoaHY2Nizs7OXl5c2Njb7+/sZGRkeHh5ERESamprf39/t7e1WVlaLi4txcXHm5uZcXFyqqqr09PTS0tI/Pz/d3d3IyMhbW1thYWHExMTw8PARERHLy8tmZmaDg4NNTU0vLy+7u7t6eno6OjptbW0mJiaHh4cMDAxJSUnCEQLAAAAGBklEQVR4nO2ca3uiPBCGEaXWoqLiqbX1hLWH//8DX7DWkjCQgRnaa6/3uT/tLkkYbpKQk+t5AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD+72xPn3cVHIN84mE8eeg0ZOR5nXuDTsiKcPZi5jrlL86T/eG+aUgp3Rqq5p+u0qKfxL4kqossi6A8sBxjK9fk51LiDN9FDVlzd2k3WbEwLH1ZizdhSJ1aspbu0q6y+o2b3zfqsvbSiDL4snxGaV+ypvKwtGWJW+AFtiyWgUjJlbasO4WQOjVkMRrhlywNV8qyXjVC6vBl8XrsTJZKWKqyHlVC6rBlMb6EGamss0pYmrISlYgymLKeeKVF3konLE1ZOhFl8GStmaVFXKsuFGVJh3w5eLK4pUXM5upEUZZoJmHCkhVxSws4gzEOarJOSv3CBY4s/mAgPCqFpSeL/aIZcGSxhlgX1D7SarL2A62QOixZij0km8ayDlYu++8iOLL8Xyece15o/duWJatn5bL/Lopq5Ha1WT2z4lRmOur/xW1FXMe/r7u9nyymvxj/5VsxWD5O3oM4WXd/89aNsdvt8XHCaxBS7DWxyJ3lr5kQ/dzt4mi5OwV+b7MYttBQbVm8Dv4vWRCuFrerxgDs43U88dZxsl3pdDbNZK39XrLtTv+kl30pusrtl9ij1Rdv8/2n5WwSpXWuO503vXUzWcFPhreHx/Op50VxslmsmsfBhhr+5i7bsgZen8jQeTvs9kHtKtdMVmjlOudXSS/6ojCzNxxp26PmOZuK64PiCNrmg13ldGRVrzocP58m++DacoWdB7F0/ZS/TsjaFLNUxDo+v4fxZkGK05JFVvYS0qp3kbdJW0HNmkctIRj6CVmNV0SO44lvTCe0miF/zaQY0yzgDpOeiew9IwUlq1bVKhD8vAwdWTtPulT6zqpih2LGg5mCkiVdK431ZW1lEXHuTK3zWzNJUpZ0afKzry2LtT9cxdFVuah+0bfS0LKkS8sfz4qyvj5I4lWmafVdiS2tOzsNLcubS9dL59qy5Nthlbaodl7IMLQSDL4vvMsiG6jL8obSFdOqURiRvDjtL5XlTWXd/E5N1ux2RdhxPZTfk6gag2KqclmpLtFOQaIvy/N6orM0cdktbQsZxAJ0layUlX96WhJTcQ5tyEp7001wenpoGFJZQyROyZ2IZA5ZV/qj1Tbxo3riIiVZY72Q9rw7ZlDpeLLIKJ2vt3D+TFOWGVJ3nYU0W344QiKr1ohIuKYS1pdlRpmKi7N2QQ1j48MvyTJD6q57peLIXos4Ebojy5bJMpgGVlnL2R/IytOf2t/PA5GqR0ilOzdFWcVRtt1v1l4pFcryioeHiimo2UpCF6Yqy7U48M4qxN5gEcmyQyomIIaTVP3L+FVZhckWq5Cy0HlY87bCfJpajyrbK1GV5Zx/L9xlFLsQmSyXByJK9thVJOtkFVYcWzim/h61aSCSZYdk1yz7espraWG2rPthtynbnX1b4pscDftVDO3ePZOV9JoSFV6X9fjd4u0qXig1K9LiqHPWyx6AiLAen1jIqPhktynrTNTxBlDHD5piNWmiHlf1Q23K8nWOrxNP1Lws4+GpTdWq025tyhpSm0v1kW02mayMhyd+47KvcNWmrEGdo6wVaJ01T3kznp1a1q9y1aasWOdnJI+Kv68wRlDUS6jekG1RVla8a8mEwbrO5r0D49GJMx3nSlctyrrsfMv7mzvxvtwPxmY8VesdB0tak3X9SIuHWkM9Wea4gUhQstjQvqzrS5K2IV++43vDmOoQozfn8kZbsm5zBmrNls/eo0+3NGGYf27q8Kjz+EhLsnLzK4mtQK77hjnEIvYPShcb2pX1YLyj/qFpOVuFunnlaB6IIXZEl05XrcgqvCJqldvN9/a5xs/bQ/dTu1eP9GW92Od0LsR1zym8hLfPuFxWYA8JiMOjnP8nR/OHj2n7C0rnoatwzB6hzvx8ByN6n2+7sM7/1QMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA4B/mPweYZ3/hed4iAAAAAElFTkSuQmCC');

insert into categories(id, category_name)
VALUES (1, 'Смартфоны'),
       (2, 'Ноутбуки'),
       (3, 'Планшеты'),
       (4, 'Смарт-часы и браслеты');

insert into subcategories(id, sub_category_name, category_id)
VALUES (1, 'Apple', 1),
       (2, 'Samsung', 1),
       (3, 'Huawei', 1),
       (4, 'Honor', 1),
       (5, 'Xiaomi', 1);

insert into subcategories(id, sub_category_name, category_id)
VALUES (6, 'Acer', 2),
       (7, 'Asus', 2),
       (8, 'Apple', 2),
       (9, 'DELL', 2),
       (10, 'Digma', 2),
       (11, 'Huawei', 2),
       (12, 'HONOR', 2),
       (13, 'Lenovo', 2),
       (14, 'HP', 2),
       (15, 'MSI', 2),
       (16, 'Xiaomi', 2);

insert into subcategories(id, sub_category_name, category_id)
VALUES (17, 'Acer', 3),
       (18, 'Asus', 3),
       (19, 'Apple', 3),
       (20, 'DELL', 3),
       (21, 'Digma', 3),
       (22, 'Huawei', 3),
       (23, 'HONOR', 3),
       (24, 'Lenovo', 3),
       (25, 'HP', 3),
       (26, 'MSI', 3),
       (27, 'Xiaomi', 3);

insert into subcategories(id, sub_category_name, category_id)
VALUES (28, 'Смарт-часы Apple watch', 4),
       (29, 'Умные часы для взрослых', 4),
       (30, 'Умные часы для детей', 4),
       (31, 'Фитнес браслет', 4);

insert into discounts(id, amount_of_discount, discount_end_date, discount_start_date)
VALUES (1, 5, '2023-02-01', '2023-02-20'),
       (2, 10, '2023-06-01', '2023-02-25'),
       (3, 5, '2023-06-01', '2023-02-25'),
       (4, 10, '2023-06-01', '2023-02-25'),
       (5, 15, '2023-06-01', '2023-02-25'),
       (6, 5, '2023-06-01', '2023-02-25'),
       (7, 10, '2023-06-01', '2023-02-25'),
       (8, 5, '2023-06-01', '2023-02-25');

insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (1,
        'https://9to5mac.com/wp-content/uploads/sites/6/2021/03/Screenshot-2021-03-26-at-11.06.19.png',
        '#000000',
        '2023-03-13 18:20:03',
        'IPhone 13 Pro — новейший флагманский смартфон Apple, предлагающий сочетание передовых технологий и стильного дизайна. Этот телефон с потрясающим 6,1-дюймовым дисплеем Super Retina XDR, тройными задними камерами с улучшенной производительностью при слабом освещении и мощным чипом A15 Bionic обеспечивает исключительный пользовательский опыт. Pro также имеет возможность подключения 5G, обеспечивая молниеносную скорость загрузки и выгрузки, а также аккумулятор с длительным сроком службы, чтобы вы могли оставаться на связи в течение всего дня. Кроме того, он работает на последней версии iOS и включает новые функции, такие как Face ID и Touch ID, обеспечивающие повышенную безопасность и удобство. iPhone 13 Pro — это незаменимое устройство для всех, кто ищет высокопроизводительный стильный смартфон с новейшими функциями и технологиями.',
        12,
        125,
        'https://svetofor.info/images/detailed/235/smartfon-apple-iphone-13-pro-128-gb-ram-gb-graphite-1.jpg',
        'IPhone 13 Pro',
        100000,
        4.5,
        0,
        341351332,
        'https://youtu.be/6wccuJTE3nY',
        1, 1, 1, 1, '03.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (1, '#000000', 125, 100000, 1),
       (2, '#B2B2B2', 104, 110000, 1),
       (3, '#FFFFBE', 83, 105000, 1),
       (4, '#0071FF', 96, 115000, 1);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (1, '1', 'simCard'),
       (1, '256', 'memoryOfPhone'),
       (1, '4', 'ramOfPhone'),
       (2, '2', 'simCard'),
       (2, '256', 'memoryOfPhone'),
       (2, '4', 'ramOfPhone'),
       (3, '2', 'simCard'),
       (3, '512', 'memoryOfPhone'),
       (3, '4', 'ramOfPhone'),
       (4, '2', 'simCard'),
       (4, '1000', 'memoryOfPhone'),
       (4, '4', 'ramOfPhone');

insert into subproduct_images(id, image_url)
values (1, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3153_0_1.jpg'),
       (1, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3153_1_1.jpg'),
       (1, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3153_3_1.jpg'),
       (1, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3153_7_1.jpg'),
       (1, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3153_4_1.jpg'),

       (2, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3154_0_1.jpg'),
       (2, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3154_1_1.jpg'),
       (2, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3154_7_1.jpg'),
       (2, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3154_3_1.jpg'),
       (2, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3154_2_1.jpg'),

       (3, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3155_0_1.jpg'),
       (3, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3155_1_1.jpg'),
       (3, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3155_3_1.jpg'),
       (3, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3155_7_1.jpg'),
       (3, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3155_4_1.jpg'),

       (4, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3156_0_1.jpg'),
       (4, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3156_1_1.jpg'),
       (4, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3156_3_1.jpg'),
       (4, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3156_7_1.jpg'),
       (4, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3156_4_1.jpg');


insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (2,
        'https://english.onlinekhabar.com/wp-content/uploads/2022/02/galaxy-s22_banner_ar.jpg',
        '#FFEBBE',
        '2023-03-14 18:20:03',
        'Samsung Galaxy S22 — последнее дополнение к флагманской линейке смартфонов Samsung, предлагающее передовые технологии и стильный дизайн. Благодаря большому яркому 6,2-дюймовому дисплею, тройным задним камерам и мощному восьмиядерному процессору этот телефон обеспечивает непревзойденное удобство работы с пользователем. S22 также может похвастаться возможностью подключения 5G, обеспечивающей молниеносную скорость загрузки и выгрузки, а также аккумулятором с длительным сроком службы, чтобы вы могли оставаться на связи в течение всего дня. Кроме того, он работает на последней версии Android и имеет улучшенный помощник Bixby AI. В общем, Samsung Galaxy S22 — незаменимое устройство для тех, кто ищет высокопроизводительный и стильный смартфон.',
        6,
        254,
        'https://object.pscloud.io/cms/cms/Photo/img_0_77_3395_2_1.jpg',
        'Samsung Galaxy S22',
        75440,
        4,
        0,
        1324132,
        'https://youtu.be/9RmCoWuN8RI',
        2, 1, 2, 2, '03.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (5, '#FFEBBE', 254, 75440, 2),
       (6, '#38A800', 98, 80440, 2),
       (7, '#000000', 56, 73440, 2),
       (8, '#CD6699', 74, 78440, 2);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (5, '1', 'simCard'),
       (5, '512', 'memoryOfPhone'),
       (5, '4', 'ramOfPhone'),
       (6, '2', 'simCard'),
       (6, '256', 'memoryOfPhone'),
       (6, '4', 'ramOfPhone'),
       (7, '2', 'simCard'),
       (7, '512', 'memoryOfPhone'),
       (7, '4', 'ramOfPhone'),
       (8, '2', 'simCard'),
       (8, '1000', 'memoryOfPhone'),
       (8, '4', 'ramOfPhone');

insert into subproduct_images(id, image_url)
values (5, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3395_2_1.jpg'),
       (5, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3395_4_1.jpg'),
       (5, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3395_3_1.jpg'),
       (5, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3395_5_1.jpg'),
       (5, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3395_1_1.jpg'),

       (6, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3396_2_1.jpg'),
       (6, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3396_3_1.jpg'),
       (6, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3396_5_1.jpg'),
       (6, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3396_0_1.jpg'),
       (6, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3396_8_1.jpg'),

       (7, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3397_2_1.jpg'),
       (7, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3397_4_1.jpg'),
       (7, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3397_3_1.jpg'),
       (7, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3397_0_1.jpg'),
       (7, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3397_8_1.jpg'),

       (8, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3651_3_6.png'),
       (8, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3651_0_6.png'),
       (8, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3651_1_6.png'),
       (8, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3651_2_6.png');


insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (3,
        'https://awsimages.detik.net.id/community/media/visual/2022/07/04/xiaomi-12-lite-1_169.jpeg?w=1200',
        '#000000',
        '2023-03-15 18:20:03',
        'Xiaomi Mi 12 Lite — это бюджетный смартфон с впечатляющими функциями и производительностью. Благодаря большому 6,57-дюймовому дисплею Full HD+ и мощному процессору Snapdragon 732G этот телефон обеспечивает плавное и быстрое взаимодействие с пользователем. Mi 12 Lite также оснащен четырьмя камерами, в том числе 48-мегапиксельной основной камерой, обеспечивающей универсальные возможности съемки и превосходное качество фотографий. Он работает на последней версии MIUI и питается от большой батареи с длительным сроком службы. Кроме того, он включает в себя подключение 5G для молниеносной скорости загрузки и выгрузки. Xiaomi Mi 12 Lite — отличный выбор для тех, кто ищет высокопроизводительный смартфон по доступной цене.',
        8,
        387,
        'https://object.pscloud.io/cms/cms/Photo/img_0_77_3624_0_1.jpg',
        'Xiaomi Mi 12 Lite',
        65990,
        5,
        0,
        289476592,
        'https://youtu.be/VMO6rN_dTxk',
        3, 1, null, 5, '03.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (9, '#000000', 387, 65990, 3),
       (10, '#FFEBBE', 273, 63990, 3),
       (11, '#5C8944', 145, 68990, 3);


insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (9, '2', 'simCard'),
       (9, '64', 'memoryOfPhone'),
       (9, '6', 'ramOfPhone'),
       (10, '2', 'simCard'),
       (10, '256', 'memoryOfPhone'),
       (10, '6', 'ramOfPhone'),
       (11, '2', 'simCard'),
       (11, '512', 'memoryOfPhone'),
       (11, '6', 'ramOfPhone');

insert into subproduct_images(id, image_url)
values (9, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3624_0_1.jpg'),
       (9, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3624_3_1.jpg'),
       (9, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3624_2_1.jpg'),
       (9, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3624_1_1.jpg'),

       (10, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3626_0_1.jpg'),
       (10, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3626_2_1.jpg'),
       (10, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3626_1_1.jpg'),
       (10, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3626_3_1.jpg'),

       (11, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3625_0_1.jpg'),
       (11, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3625_2_1.jpg'),
       (11, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3625_1_1.jpg'),
       (11, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3625_3_1.jpg');



insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (4,
        'https://cdn.osxdaily.com/wp-content/uploads/2022/09/iphone-14-pro-iphone-14-pro-max.jpg',
        '#73004C',
        '2023-03-16 18:20:03',
        'IPhone 14 Pro Max — новейший флагманский смартфон Apple, предлагающий сочетание передовых технологий и стильного дизайна. Этот телефон с потрясающим 6,1-дюймовым дисплеем Super Retina XDR, тройными задними камерами с улучшенной производительностью при слабом освещении и мощным чипом A16 Bionic обеспечивает исключительный пользовательский опыт. Pro Max также имеет возможность подключения 5G, обеспечивая молниеносную скорость загрузки и выгрузки, а также аккумулятор с длительным сроком службы, чтобы вы могли оставаться на связи в течение всего дня. Кроме того, он работает на последней версии iOS и включает новые функции, такие как Face ID и Touch ID, обеспечивающие повышенную безопасность и удобство. iPhone 13 Pro — это незаменимое устройство для всех, кто ищет высокопроизводительный стильный смартфон с новейшими функциями и технологиями.',
        16,
        132,
        'https://object.pscloud.io/cms/cms/Photo/img_0_77_3814_4_6.png',
        'IPhone 14 Pro Max',
        124990,
        4,
        1,
        43252435,
        'https://youtu.be/4QmRq3EkQeo',
        1, 1, null, 1, '03.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (12, '#73004C', 132, 124990, 4),
       (13, '#E69800', 108, 122590, 4),
       (14, '#343434', 78, 125990, 4),
       (15, '#000000', 93, 124990, 4);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (12, 'eSIM', 'simCard'),
       (12, '524', 'memoryOfPhone'),
       (12, '4', 'ramOfPhone'),
       (13, '2', 'simCard'),
       (13, '256', 'memoryOfPhone'),
       (13, '4', 'ramOfPhone'),
       (14, '2', 'simCard'),
       (14, '512', 'memoryOfPhone'),
       (14, '4', 'ramOfPhone'),
       (15, '1', 'simCard'),
       (15, '1000', 'memoryOfPhone'),
       (15, '4', 'ramOfPhone');

insert into subproduct_images(id, image_url)
values (12, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3814_4_6.png'),
       (12, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3814_0_6.webp'),
       (12, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3814_1_6.png'),
       (12, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3814_0_1.jpg'),
       (12, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3814_1_1.jpg'),

       (13, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3813_0_6.png'),
       (13, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3813_1_6.png'),
       (13, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3813_2_6.png'),
       (13, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3813_1_1.jpg'),
       (13, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3813_0_1.jpg'),

       (14, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3812_4_6.png'),
       (14, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3812_0_6.png'),
       (14, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3812_1_6.png'),
       (14, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3812_0_1.jpg'),
       (14, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3812_1_1.jpg'),

       (15, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3811_4_6.png'),
       (15, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3811_0_6.png'),
       (15, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3811_1_6.png'),
       (15, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3811_1_1.jpg'),
       (15, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3811_0_1.jpg');



insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (5,
        'https://it-here.ru/wp-content/uploads/2021/09/iPhone-13-hero-1536x482-1.png',
        '#0370CB',
        '2023-03-16 18:20:03',
        'IPhone 13 — новейший флагманский смартфон Apple, предлагающий сочетание передовых технологий и стильного дизайна. Этот телефон с потрясающим 6,1-дюймовым дисплеем Super Retina XDR, тройными задними камерами с улучшенной производительностью при слабом освещении и мощным чипом A16 Bionic обеспечивает исключительный пользовательский опыт. Pro Max также имеет возможность подключения 5G, обеспечивая молниеносную скорость загрузки и выгрузки, а также аккумулятор с длительным сроком службы, чтобы вы могли оставаться на связи в течение всего дня. Кроме того, он работает на последней версии iOS и включает новые функции, такие как Face ID и Touch ID, обеспечивающие повышенную безопасность и удобство. iPhone 13 Pro — это незаменимое устройство для всех, кто ищет высокопроизводительный стильный смартфон с новейшими функциями и технологиями.',
        13,
        78,
        'https://object.pscloud.io/cms/cms/Photo/img_0_77_3127_4_1.jpg',
        'IPhone 13',
        69990,
        4,
        1,
        27634823,
        'https://youtu.be/4QmRq3EkQeo',
        1, 1, 3, 1, '03.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (16, '#0370CB', 78, 69990, 5),
       (17, '#FF0000', 58, 68990, 5),
       (18, '#38A800', 63, 69990, 5),
       (19, '#000000', 45, 65990, 5);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (16, '1', 'simCard'),
       (16, '128', 'memoryOfPhone'),
       (16, '3', 'ramOfPhone'),
       (17, '2', 'simCard'),
       (17, '256', 'memoryOfPhone'),
       (17, '4', 'ramOfPhone'),
       (18, '2', 'simCard'),
       (18, '256', 'memoryOfPhone'),
       (18, '4', 'ramOfPhone'),
       (19, '1', 'simCard'),
       (19, '512', 'memoryOfPhone'),
       (19, '4', 'ramOfPhone');

insert into subproduct_images(id, image_url)
values (16, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3127_4_1.jpg'),
       (16, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3127_3_1.jpg'),
       (16, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3127_7_1.jpg'),
       (16, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3127_2_1.jpg'),
       (16, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3127_1_1.jpg'),

       (17, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3126_4_1.jpg'),
       (17, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3126_3_1.jpg'),
       (17, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3126_7_1.jpg'),
       (17, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3126_2_1.jpg'),
       (17, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3126_1_1.jpg'),

       (18, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3479_0_6.png'),
       (18, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3479_7_1.jpg'),
       (18, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3479_6_1.jpg'),
       (18, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3479_5_1.jpg'),

       (19, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3123_9_1.jpg'),
       (19, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3123_8_1.jpg'),
       (19, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3123_10_1.jpg'),
       (19, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3123_6_1.jpg'),
       (19, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_3123_5_1.jpg');

insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (6,
        'https://www.apple.com/v/macbook-pro-13/p/images/meta/macbook-pro-13_overview__bcsyunk73i2a_og.jpg',
        '#686868',
        '2023-03-17 18:20:03',
        'MacBook Air — это легкий и портативный ноутбук от Apple, разработанный для тех, кому нужен мощный и стильный ноутбук для работы, учебы или игр. MacBook Air с потрясающим 13,3-дюймовым дисплеем Retina обеспечивает четкое и яркое изображение, а процессор Intel Core i5 8-го поколения обеспечивает высокую производительность и быстроту отклика. Этот ноутбук также оснащен Touch ID, упрощающим и безопасным вход в систему и совершение покупок, а также последней версией macOS, обеспечивающей удобный и интуитивно понятный пользовательский интерфейс. Кроме того, он имеет долговечную батарею, обеспечивающую до 12 часов работы без подзарядки, и поставляется с быстрым и надежным хранилищем SSD. MacBook Air (13 дюймов, 2020 г.) — идеальный ноутбук для тех, кто ищет мощное, портативное и стильное устройство.',
        12,
        34,
        'https://asiastore.kg/image/cache/catalog/mac/macbookair13-m1/7bea8548b6390af692aafe6272164804-670x540.jpg',
        'Apple MacBook Air 13',
        91990,
        0,
        0,
        12367471,
        'https://youtu.be/Hw7iB-zkYrk',
        1, 2, 4, 8, '03.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (20, '#686868', 34, 91990, 6),
       (21, '#E69800', 23, 91990, 6);


insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (20, 'Apple M1', 'laptopCPU'),
       (20, '2560x1600', 'screenResolutionLaptop'),
       (20, '4', 'videoCardMemory'),
       (20, '4', 'ramLaptop'),
       (20, '13.3', 'screenSizeLaptop'),
       (21, 'Apple M1', 'laptopCPU'),
       (21, '2560x1600', 'screenResolutionLaptop'),
       (21, '6', 'videoCardMemory'),
       (21, '6', 'ramLaptop'),
       (21, '13.3', 'screenSizeLaptop');

insert into subproduct_images(id, image_url)
values (20,
        'https://asiastore.kg/image/cache/catalog/mac/macbookair13-m1/7bea8548b6390af692aafe6272164804-670x540.jpg'),
       (20,
        'https://asiastore.kg/image/cache/catalog/mac/macbookair13-m1/3c0d840024235dd9db096a0eb13f3db6-670x540.jpg'),
       (20,
        'https://asiastore.kg/image/cache/catalog/mac/macbookair13-m1/203c34c0ad6a98828ac8b6453c9e0730-670x540.jpg'),
       (20,
        'https://asiastore.kg/image/cache/catalog/mac/macbookair13-m1/ae6aa36484f09d84bde2afe69ba16a73-670x540.jpg'),
       (20,
        'https://asiastore.kg/image/cache/catalog/mac/macbookair13-m1/e5da48d8e45181e185f6e6cc76184c05-670x540.jpg'),

       (21,
        'https://asiastore.kg/image/cache/catalog/mac/macbookair13-m1/gold/eee476e95a2831ed4b655a1792969882-670x540.jpg'),
       (21,
        'https://asiastore.kg/image/cache/catalog/mac/macbookair13-m1/gold/44b10d3f663de2959ed27e0bc1028b66-670x540.jpg'),
       (21,
        'https://asiastore.kg/image/cache/catalog/mac/macbookair13-m1/gold/ccda904841fb20072333ad7a178d665c-670x540.jpg'),
       (21,
        'https://asiastore.kg/image/cache/catalog/mac/macbookair13-m1/gold/9ca1ec20c27ae7debab5c4f9145bbc5c-670x540.jpg'),
       (21,
        'https://asiastore.kg/image/cache/catalog/mac/macbookair13-m1/gold/115a6efdea4238cf240f55c5ac4871f8-670x540.jpg');

insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (23,
        'https://www.notebookcheck.net/fileadmin/Notebooks/News/_nc3/csm_FBlmFlnX0AIbDre_b05127ba75.jpg',
        '#CCCCCC',
        '2023-03-20 18:20:03',
        'MacBook Pro 14 — это мощный и универсальный ноутбук от Apple, разработанный для профессионалов и опытных пользователей. Этот ноутбук с потрясающим 14-дюймовым дисплеем Retina и быстрым процессором Apple M1 Pro обеспечивает исключительное удобство работы, независимо от того, работаете ли вы над сложными задачами или используете ресурсоемкие приложения. MacBook Pro также оснащен последней версией macOS, обеспечивающей плавный и интуитивно понятный пользовательский интерфейс, а также сенсорной панелью — сенсорной полосой стекла над клавиатурой, обеспечивающей быстрый доступ к распространенным инструментам и функциям. Кроме того, он имеет долговечную батарею, обеспечивающую до 14 часов работы без подзарядки, и поставляется с быстрым и надежным хранилищем SSD. MacBook Pro — идеальный ноутбук для тех, кто ищет мощное, универсальное и стильное устройство для работы или личного использования.',
        8,
        29,
        'https://object.pscloud.io/cms/cms/Photo/img_0_62_2448_0_1.jpg',
        'Apple MacBook Pro 14',
        189990,
        4.5,
        1,
        24352453,
        'https://youtu.be/yGjb3vBnuJo',
        1, 2, 1, 8, '03.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (22, '#CCCCCC', 29, 189990, 23);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (22, 'Apple M1 Pro', 'laptopCPU'),
       (22, '3024×1964', 'screenResolutionLaptop'),
       (22, '8', 'videoCardMemory'),
       (22, '32', 'ramLaptop'),
       (22, '14', 'screenSizeLaptop');

insert into subproduct_images(id, image_url)
values (22, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2448_0_1.jpg'),
       (22, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2448_1_1.jpg'),
       (22, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2448_2_1.jpg'),
       (22, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2448_3_1.jpg');

insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (8,
        'https://images.acer.com/is/image/acer/Nitro_5_main_2560-1?$responsive$',
        '#000000',
        '2023-03-21 18:20:03',
        'Acer Nitro 5 — доступный игровой ноутбук с впечатляющей производительностью и функциями. Благодаря быстрому процессору Intel Core i5 и выделенной графике NVIDIA этот ноутбук обеспечивает плавную и быструю работу даже в ресурсоемких играх и приложениях. Nitro 5 оснащен большим 15,6-дюймовым дисплеем Full HD для четкого и яркого изображения, а также клавиатурой с подсветкой для комфортной игры в условиях низкой освещенности. Кроме того, он оснащен аккумулятором с длительным сроком службы, обеспечивающим до 6 часов работы без подзарядки. , а также быстрое и надежное хранилище Acer Nitro 5 — отличный выбор для геймеров и опытных пользователей, которые ищут недорогой ноутбук с отличной производительностью и функциями.',
        5,
        54,
        'https://object.pscloud.io/cms/cms/Photo/img_0_62_2684_0_1.jpg',
        'Acer Nitro 5',
        149990,
        0,
        1,
        98245425,
        'https://youtu.be/KlmopqEx2w0',
        4, 2, null, 6, '03.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (23, '#000000', 54, 149990, 8);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (23, 'AMD Ryzen 5', 'laptopCPU'),
       (23, '1920х1080', 'screenResolutionLaptop'),
       (23, '8', 'videoCardMemory'),
       (23, '16', 'ramLaptop'),
       (23, '15.6', 'screenSizeLaptop');

insert into subproduct_images(id, image_url)
values (23, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2684_0_1.jpg'),
       (23, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2684_1_1.jpg'),
       (23, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2684_2_1.jpg'),
       (23, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2684_3_1.jpg');

insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)

VALUES (9,
        'http://reviewcentralme.com/wp-content/uploads/2022/09/Vivobook-15_X1502_M150.jpg',
        '#000000',
        '2023-03-25 18:20:03',
        'Asus VivoBook 15 — это недорогой ноутбук с отличной производительностью и функциями для повседневного использования. Благодаря быстрому процессору Intel Core i5 и дисплею Full HD этот ноутбук обеспечивает плавную и быструю работу, независимо от того, работаете ли вы, просматриваете веб-страницы или смотрите видео. VivoBook 15 также отличается элегантным и стильным дизайном, тонким и легким форм-фактором, который позволяет легко носить его с собой и использовать в дороге. Кроме того, он имеет аккумулятор с длительным сроком службы, обеспечивающий до 6 часов работы без подзарядки, а также быстрые и надежные варианты хранения. Asus VivoBook 15 — отличный выбор для тех, кто ищет недорогой ноутбук, обеспечивающий производительность и функции, необходимые для повседневного использования.',
        5,
        34,
        'https://content.rozetka.com.ua/goods/images/big/269677917.jpg',
        'Asus VivoBook 15',
        69990,
        0,
        0,
        123987985,
        'https://youtu.be/bjZ0kymy-Zs',
        5, 2, 5, 7, '03.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (24, '#000000', 87, 69990, 9);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (24, 'Intel Core i5', 'laptopCPU'),
       (24, '1920х1080', 'screenResolutionLaptop'),
       (24, '4', 'videoCardMemory'),
       (24, '8', 'ramLaptop'),
       (24, '15.6', 'screenSizeLaptop');

insert into subproduct_images(id, image_url)
values (24, 'https://content.rozetka.com.ua/goods/images/big/269677917.jpg'),
       (24, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2521_1_1.jpg'),
       (24, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2521_2_1.jpg'),
       (24, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2521_3_1.jpg'),
       (24, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2521_1_6.png'),
       (24, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2521_0_6.png');

insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (10,
        'https://cdnb.artstation.com/p/assets/images/images/014/956/421/large/marcus-ryden-asuszenbook.jpg?1546467187',
        '#000000',
        '2023-03-19 18:20:03',
        'Asus ZenBook Pro 15 — это недорогой ноутбук с отличной производительностью и функциями для повседневного использования. Благодаря быстрому процессору Intel Core i5 и дисплею Full HD этот ноутбук обеспечивает плавную и быструю работу, независимо от того, работаете ли вы, просматриваете веб-страницы или смотрите видео. VivoBook 15 также отличается элегантным и стильным дизайном, тонким и легким форм-фактором, который позволяет легко носить его с собой и использовать в дороге. Кроме того, он имеет аккумулятор с длительным сроком службы, обеспечивающий до 6 часов работы без подзарядки, а также быстрые и надежные варианты хранения. Asus VivoBook 15 — отличный выбор для тех, кто ищет недорогой ноутбук, обеспечивающий производительность и функции, необходимые для повседневного использования.',
        8,
        39,
        'https://www.asus.com/media/global/gallery/o4znfiih78dmqfwh_setting_xxx_0_90_end_2000.png',
        'Asus ZenBook Pro 15',
        75990,
        0,
        1,
        3489534,
        'https://youtu.be/cUAwfZtoGYM',
        5, 2, null, 7, '03.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (25, '#000000', 39, 75990, 10);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (25, 'Intel Core i7', 'laptopCPU'),
       (25, '1920х1080', 'screenResolutionLaptop'),
       (25, '6', 'videoCardMemory'),
       (25, '8', 'ramLaptop'),
       (25, '15.6', 'screenSizeLaptop');

insert into subproduct_images(id, image_url)
values (25, 'https://www.asus.com/media/global/gallery/o4znfiih78dmqfwh_setting_xxx_0_90_end_2000.png'),
       (25, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2145_1_6.png'),
       (25, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2145_3_6.png'),
       (25, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2145_2_6.png');


insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (11,
        'https://appleinsider.ru/wp-content/uploads/2022/03/iPad_air_5_2022_000989-740x462.jpg',
        '#3B3AC4',
        '2023-03-01 18:20:03',
        'iPad Air (10,9 дюйма, 2020 г.) — это мощный и универсальный планшет от Apple, разработанный для работы, учебы и развлечений. Благодаря большому и яркому 10,9-дюймовому дисплею Liquid Retina и быстрому процессору A14 Bionic этот планшет обеспечивает плавную и быструю работу, независимо от того, просматриваете ли вы веб-страницы, играете в игры или используете ресурсоемкие приложения. iPad Air также включает поддержку Apple Pencil и Smart Keyboard, что делает его отличным выбором для творческих задач и продуктивной работы. Кроме того, он имеет аккумулятор с длительным сроком службы, обеспечивающий до 10 часов работы без подзарядки, и работает на последней версии iPadOS, обеспечивая плавный и интуитивно понятный пользовательский интерфейс. iPad Air (10,9 дюйма, 2020 г.) — идеальный планшет для тех, кто ищет мощное, универсальное и стильное устройство для работы или личного использования.',
        12,
        23,
        'https://object.pscloud.io/cms/cms/Photo/img_0_64_646_0_1.jpg',
        'Apple iPad Air 10.9',
        69990,
        0,
        0,
        62435243,
        'https://youtu.be/Kb_kIq5tMGQ',
        1, 3, null, 19, '03.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (26, '#3B3AC4', 23, 69990, 11),
       (27, '#002673', 30, 71990, 11),
       (28, '#FFEBBE', 35, 68990, 11),
       (29, '#B2B2B2', 29, 69990, 11);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (26, '2388x1668', 'screenResolutionOfTablet'),
       (26, '11', 'screenSizeOfTablet'),
       (26, '64', 'memoryOfTablet'),
       (26, '6', 'ramOfTablet'),
       (26, '9 - 11', 'screenDiagonalOfTablet'),
       (26, '2400 - 4799мА/час', 'batteryCapacityOfTablet'),
       (27, '2388x1668', 'screenResolutionOfTablet'),
       (27, '11', 'screenSizeOfTablet'),
       (27, '128', 'memoryOfTablet'),
       (27, '4', 'ramOfTablet'),
       (27, '9 - 11', 'screenDiagonalOfTablet'),
       (27, '2400 - 4799мА/час', 'batteryCapacityOfTablet'),
       (28, '2388x1668', 'screenResolutionOfTablet'),
       (28, '11', 'screenSizeOfTablet'),
       (28, '64', 'memoryOfTablet'),
       (28, '4', 'ramOfTablet'),
       (28, '9 - 11', 'screenDiagonalOfTablet'),
       (29, '2388x1668', 'screenResolutionOfTablet'),
       (29, '11', 'screenSizeOfTablet'),
       (29, '256', 'memoryOfTablet'),
       (29, '6', 'ramOfTablet'),
       (29, '9 - 11', 'screenDiagonalOfTablet'),
       (29, '2400 - 4799мА/час', 'batteryCapacityOfTablet');

insert into subproduct_images(id, image_url)
values (26, 'https://object.pscloud.io/cms/cms/Photo/img_0_64_646_0_1.jpg'),
       (26, 'https://object.pscloud.io/cms/cms/Photo/img_0_64_646_1_1.jpg'),

       (27, 'https://object.pscloud.io/cms/cms/Photo/img_0_64_647_0_1.jpg'),
       (27, 'https://object.pscloud.io/cms/cms/Photo/img_0_64_647_1_1.jpg'),

       (28, 'https://object.pscloud.io/cms/cms/Photo/img_0_64_645_0_1.jpg'),
       (28, 'https://object.pscloud.io/cms/cms/Photo/img_0_64_645_1_1.jpg'),

       (29, 'https://object.pscloud.io/cms/cms/Photo/img_0_64_644_0_1.jpg'),
       (29, 'https://object.pscloud.io/cms/cms/Photo/img_0_64_644_1_1.jpg');


insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (12,
        'https://appleinsider.ru/wp-content/uploads/2022/03/iPad_air_5_2022_000989-740x462.jpg',
        '#0071FF',
        '2023-03-02 18:20:03',
        'iPad Mini (6 дюйма, 2020 г.) — это мощный и универсальный планшет от Apple, разработанный для работы, учебы и развлечений. Благодаря большому и яркому 10,9-дюймовому дисплею Liquid Retina и быстрому процессору A14 Bionic этот планшет обеспечивает плавную и быструю работу, независимо от того, просматриваете ли вы веб-страницы, играете в игры или используете ресурсоемкие приложения. iPad Air также включает поддержку Apple Pencil и Smart Keyboard, что делает его отличным выбором для творческих задач и продуктивной работы. Кроме того, он имеет аккумулятор с длительным сроком службы, обеспечивающий до 10 часов работы без подзарядки, и работает на последней версии iPadOS, обеспечивая плавный и интуитивно понятный пользовательский интерфейс. iPad Air (10,9 дюйма, 2020 г.) — идеальный планшет для тех, кто ищет мощное, универсальное и стильное устройство для работы или личного использования.',
        9,
        56,
        'https://object.pscloud.io/cms/cms/Photo/img_0_64_765_8_1.jpg',
        'Apple iPad Mini 6',
        59990,
        0,
        1,
        423524,
        'https://youtu.be/LBEGCC5oMCw',
        1, 3, null, 19, '03.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (30, '#0071FF', 56, 59990, 12);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (30, '2388x1668', 'screenResolutionOfTablet'),
       (30, '11', 'screenSizeOfTablet'),
       (30, '64', 'memoryOfTablet'),
       (30, '6', 'ramOfTablet'),
       (30, '9 - 11', 'screenDiagonalOfTablet'),
       (30, '2400 - 4799мА/час', 'batteryCapacityOfTablet');

insert into subproduct_images(id, image_url)
values (30, 'https://object.pscloud.io/cms/cms/Photo/img_0_64_765_8_1.jpg'),
       (30, 'https://object.pscloud.io/cms/cms/Photo/img_0_64_765_7_1.jpg'),
       (30, 'https://object.pscloud.io/cms/cms/Photo/img_0_64_765_6_1.jpg');


insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (13,
        'https://www.apple.com/newsroom/images/product/ipad/standard/apple_ipad-pro-spring21_lp_04202021.jpg.og.jpg?202301192200',
        '#000000',
        '2023-03-03 18:20:03',
        'iPad Pro — это мощный и универсальный планшет от Apple, разработанный для работы, учебы и развлечений. Благодаря большому и яркому 10,9-дюймовому дисплею Liquid Retina и быстрому процессору A14 Bionic этот планшет обеспечивает плавную и быструю работу, независимо от того, просматриваете ли вы веб-страницы, играете в игры или используете ресурсоемкие приложения. iPad Air также включает поддержку Apple Pencil и Smart Keyboard, что делает его отличным выбором для творческих задач и продуктивной работы. Кроме того, он имеет аккумулятор с длительным сроком службы, обеспечивающий до 10 часов работы без подзарядки, и работает на последней версии iPadOS, обеспечивая плавный и интуитивно понятный пользовательский интерфейс. iPad Air (10,9 дюйма, 2020 г.) — идеальный планшет для тех, кто ищет мощное, универсальное и стильное устройство для работы или личного использования.',
        9,
        56,
        'https://object.pscloud.io/cms/cms/Photo/img_0_64_697_0_1.jpg',
        'Apple iPad Pro',
        139990,
        0,
        0,
        82452443,
        'https://youtu.be/xhb68TUGyIo',
        1, 3, 6, 19, '03.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (31, '#000000', 56, 139990, 13);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (31, '2388x1668', 'screenResolutionOfTablet'),
       (31, '11', 'screenSizeOfTablet'),
       (31, '512', 'memoryOfTablet'),
       (31, '8', 'ramOfTablet'),
       (31, '9 - 11', 'screenDiagonalOfTablet'),
       (31, '2400 - 4799мА/час', 'batteryCapacityOfTablet');

insert into subproduct_images(id, image_url)
values (31, 'https://object.pscloud.io/cms/cms/Photo/img_0_64_697_0_1.jpg'),
       (31, 'https://object.pscloud.io/cms/cms/Photo/img_0_64_697_1_1.jpg'),
       (31, 'https://object.pscloud.io/cms/cms/Photo/img_0_64_697_2_1.jpg');


insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (14,
        'https://www.m1.com.sg/-/media/Images/Personal/Promotions/applewatch7/1440x671_watchs7.jpg',
        '#0071FF',
        '2023-03-05 18:20:03',
        'Apple Watch Series 7 — это мощные и стильные смарт-часы от Apple, предназначенные для фитнеса, здоровья и подключения. Благодаря быстрому процессору S6 SiP и яркому постоянно включенному дисплею Retina эти часы обеспечивают плавную и быструю работу, независимо от того, отслеживаете ли вы свои тренировки, отслеживаете частоту сердечных сокращений или проверяете свои уведомления. Series 6 также имеет широкий спектр датчиков здоровья и фитнеса, включая датчик кислорода в крови, приложение для ЭКГ и обнаружение падения. Кроме того, он имеет аккумулятор с длительным сроком службы, обеспечивающий до 18 часов работы без подзарядки, и включает в себя возможности подключения к сотовой сети для совершения звонков и отправки текстовых сообщений без телефона. Apple Watch Series 6 — это идеальные смарт-часы для тех, кто ищет мощное и стильное устройство для фитнеса, здоровья и связи.',
        4,
        37,
        'https://object.pscloud.io/cms/cms/Photo/img_0_911_598_0_1.jpg',
        'Apple Watch Series 7',
        49990,
        5,
        1,
        52452435,
        'https://youtu.be/JRsEa7YTOiE',
        1, 4, 7, 28, '03.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (32, '#0071FF', 37, 49990, 14);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (32, 'Wi-Fi', 'wirelessInterface'),
       (32, '16', 'memoryOfSmartWatch'),
       (32, 'square', 'caseShape'),
       (32, 'Silicon', 'braceletMaterial'),
       (32, 'Unisex', 'gender'),
       (32, 'Yes', 'waterProof'),
       (32, '13', 'screenDiagonalOfSmartWatch'),
       (32, 'aluminum', 'housingMaterial');

insert into subproduct_images(id, image_url)
values (32, 'https://object.pscloud.io/cms/cms/Photo/img_0_911_598_0_1.jpg'),
       (32, 'https://object.pscloud.io/cms/cms/Photo/img_0_911_598_1_1.jpg'),
       (32, 'https://object.pscloud.io/cms/cms/Photo/img_0_911_598_2_1.jpg');


insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (15,
        'https://my-apple-store.ru/wa-data/public/site/watch-7/nike-banner.jpg',
        '#B2B2B2',
        '2023-03-06 18:20:03',
        'Apple Watch Nike — это специальная версия Apple Watch, разработанная специально для спортсменов и любителей фитнеса. Они обладают всеми мощными функциями для здоровья и фитнеса стандартных Apple Watch, включая быстрый S6 SiP, яркий и всегда включенный дисплей Retina, а также ряд датчиков здоровья и фитнеса. Кроме того, он включает в себя эксклюзивные циферблаты Nike и спортивные ремешки Nike, а также интеграцию с приложением Nike Run Club для отслеживания ваших пробежек и постановки целей в фитнесе. Apple Watch Nike — идеальные смарт-часы для тех, кто ищет мощное и стильное устройство для фитнеса и занятий спортом. Бегаете ли вы, катаетесь на велосипеде или тренируетесь в тренажерном зале, Apple Watch Nike помогут вам сохранять мотивацию, не отставать от цели и поддерживать связь со своими целями в области здоровья и фитнеса.',
        4,
        73,
        'https://object.pscloud.io/cms/cms/Photo/img_0_911_456_0_6.png',
        'Apple Watch Nike',
        49990,
        4,
        1,
        2346646643,
        'https://youtu.be/60RaXZ01P1Q',
        1, 4, 8, 28, '03.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (33, '#B2B2B2', 73, 49990, 15);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (33, 'Wi-Fi', 'wirelessInterface'),
       (33, '16', 'memoryOfSmartWatch'),
       (33, 'square', 'caseShape'),
       (33, 'Silicon', 'braceletMaterial'),
       (33, 'Unisex', 'gender'),
       (33, 'Yes', 'waterProof'),
       (33, '13', 'screenDiagonalOfSmartWatch'),
       (33, 'aluminum', 'housingMaterial');

insert into subproduct_images(id, image_url)
values (33, 'https://object.pscloud.io/cms/cms/Photo/img_0_911_456_0_6.png'),
       (33, 'https://object.pscloud.io/cms/cms/Photo/img_0_911_456_1_1.jpg'),
       (33, 'https://object.pscloud.io/cms/cms/Photo/img_0_911_456_2_1.jpg');


insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (16,
        'https://9to5mac.com/wp-content/uploads/sites/6/2023/03/yellow-iphone-14-1.jpg?quality=82&strip=all',
        '#FFFFBE',
        '2023-03-08 18:20:03',
        'IPhone 14 Plus — новейший флагманский смартфон Apple, предлагающий сочетание передовых технологий и стильного дизайна. Этот телефон с потрясающим 6,1-дюймовым дисплеем Super Retina XDR, тройными задними камерами с улучшенной производительностью при слабом освещении и мощным чипом A15 Bionic обеспечивает исключительный пользовательский опыт. Pro также имеет возможность подключения 5G, обеспечивая молниеносную скорость загрузки и выгрузки, а также аккумулятор с длительным сроком службы, чтобы вы могли оставаться на связи в течение всего дня. Кроме того, он работает на последней версии iOS и включает новые функции, такие как Face ID и Touch ID, обеспечивающие повышенную безопасность и удобство. iPhone 13 Pro — это незаменимое устройство для всех, кто ищет высокопроизводительный стильный смартфон с новейшими функциями и технологиями.',
        12,
        200,
        'https://object.pscloud.io/cms/cms/Photo/img_0_77_4325_0_1.jpg',
        'IPhone 14 Plus',
        115990,
        0,
        0,
        34124451332,
        'https://youtu.be/jVw_Hj_netI',
        1, 1, 1, 1, '03.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (34, '#FFFFBE', 200, 115990, 16);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (34, '2', 'simCard'),
       (34, '512', 'memoryOfPhone'),
       (34, '4', 'ramOfPhone');

insert into subproduct_images(id, image_url)
values (34, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4325_0_1.jpg'),
       (34, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4325_1_1.jpg'),
       (34, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4325_2_1.jpg'),
       (34, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4325_9_1.jpg');

insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (17,
        'https://www.androidauthority.com/wp-content/uploads/2020/04/iPhone-SE-review-header.jpg',
        '#FF0000',
        '2023-03-09 18:20:03',
        'Iphone SE 2020 — новейший флагманский смартфон Apple, предлагающий сочетание передовых технологий и стильного дизайна. Этот телефон с потрясающим 6,1-дюймовым дисплеем Super Retina XDR, тройными задними камерами с улучшенной производительностью при слабом освещении и мощным чипом A15 Bionic обеспечивает исключительный пользовательский опыт. Pro также имеет возможность подключения 5G, обеспечивая молниеносную скорость загрузки и выгрузки, а также аккумулятор с длительным сроком службы, чтобы вы могли оставаться на связи в течение всего дня. Кроме того, он работает на последней версии iOS и включает новые функции, такие как Face ID и Touch ID, обеспечивающие повышенную безопасность и удобство. iPhone 13 Pro — это незаменимое устройство для всех, кто ищет высокопроизводительный стильный смартфон с новейшими функциями и технологиями.',
        12,
        27,
        'https://object.pscloud.io/cms/cms/Photo/img_0_77_2388_0_1.jpg',
        'IPhone SE 2020',
        42990,
        0,
        1,
        342454781332,
        'https://youtu.be/jVUlApyShaA',
        1, 1, 1, 1, '03.03.20');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (35, '#FF0000', 27, 42990, 17);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (35, '1', 'simCard'),
       (35, '64', 'memoryOfPhone'),
       (35, '3', 'ramOfPhone');

insert into subproduct_images(id, image_url)
values (35, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_2388_0_1.jpg'),
       (35, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_2388_2.png'),
       (35, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_2388_1.png'),
       (35, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_2388_0.png');

insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (18,
        'https://mobidevices.com/images/2019/09/iPhone-11-iPhone-11-Pro-and-iPhone-11-Pro-Max.jpeg',
        '#FFFFFF',
        '2023-03-09 18:20:03',
        'Iphone 11 — новейший флагманский смартфон Apple, предлагающий сочетание передовых технологий и стильного дизайна. Этот телефон с потрясающим 6,1-дюймовым дисплеем Super Retina XDR, тройными задними камерами с улучшенной производительностью при слабом освещении и мощным чипом A15 Bionic обеспечивает исключительный пользовательский опыт. Pro также имеет возможность подключения 5G, обеспечивая молниеносную скорость загрузки и выгрузки, а также аккумулятор с длительным сроком службы, чтобы вы могли оставаться на связи в течение всего дня. Кроме того, он работает на последней версии iOS и включает новые функции, такие как Face ID и Touch ID, обеспечивающие повышенную безопасность и удобство. iPhone 13 Pro — это незаменимое устройство для всех, кто ищет высокопроизводительный стильный смартфон с новейшими функциями и технологиями.',
        12,
        132,
        'https://object.pscloud.io/cms/cms/Photo/img_0_77_2732_3_1.jpg',
        'IPhone 11',
        49990,
        0,
        0,
        34245478233242,
        'https://youtu.be/nVkcc03dDDU',
        1, 1, 1, 1, '03.03.20');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (36, '#FFFFFF', 132, 49990, 18);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (36, '1', 'simCard'),
       (36, '128', 'memoryOfPhone'),
       (36, '3', 'ramOfPhone');

insert into subproduct_images(id, image_url)
values (36, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_2732_3_1.jpg'),
       (36, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_2732_4_1.jpg'),
       (36, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_2732_2_1.jpg'),
       (36, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_2732_1_1.jpg');

insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (19,
        'https://softech.kg/image/catalog/Products/Phones/Samsung/01%20S23%20Ultra/1a.jpg',
        '#267300',
        '2023-03-10 18:20:03',
        'Samsung Galaxy S23 — последнее дополнение к флагманской линейке смартфонов Samsung, предлагающее передовые технологии и стильный дизайн. Благодаря большому яркому 6,2-дюймовому дисплею, тройным задним камерам и мощному восьмиядерному процессору этот телефон обеспечивает непревзойденное удобство работы с пользователем. S22 также может похвастаться возможностью подключения 5G, обеспечивающей молниеносную скорость загрузки и выгрузки, а также аккумулятором с длительным сроком службы, чтобы вы могли оставаться на связи в течение всего дня. Кроме того, он работает на последней версии Android и имеет улучшенный помощник Bixby AI. В общем, Samsung Galaxy S22 — незаменимое устройство для тех, кто ищет высокопроизводительный и стильный смартфон.',
        8,
        243,
        'https://object.pscloud.io/cms/cms/Photo/img_0_77_4248_4_6.png',
        'Samsung Galaxy S23',
        100990,
        4.5,
        1,
        13413434,
        'https://youtu.be/tHHBYTVXVXA',
        2, 1, 2, 2, '04.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (37, '#267300', 243, 100990, 19),
       (38, '#000000', 98, 111990, 19),
       (39, '#C29ED7', 56, 113590, 19);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (37, '1', 'simCard'),
       (37, '512', 'memoryOfPhone'),
       (37, '4', 'ramOfPhone'),
       (38, '2', 'simCard'),
       (38, '256', 'memoryOfPhone'),
       (38, '4', 'ramOfPhone'),
       (39, '2', 'simCard'),
       (39, '512', 'memoryOfPhone'),
       (39, '4', 'ramOfPhone');


insert into subproduct_images(id, image_url)
values (37, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4248_4_6.png'),
       (37, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4248_7_6.png'),
       (37, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4248_9_6.png'),
       (37, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4248_10_6.png'),
       (37, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4248_15_6.png'),

       (38, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4249_8_6.png'),
       (38, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4249_9_6.png'),
       (38, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4249_13_6.png'),
       (38, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4249_14_6.png'),
       (38, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4249_17_6.png'),

       (39, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4246_3_6.png'),
       (39, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4246_10_6.png'),
       (39, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4246_11_6.png'),
       (39, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4246_13_6.png'),
       (39, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_4246_2_6.png');

insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (20,
        'https://p.turbosquid.com/ts-thumb/6u/vgiKFu/a91bkiVt/iphonexryellow3dmodel001/jpg/1548182538/600x600/fit_q87/35c36b76b49bb175285e090e173815210e3caaf6/iphonexryellow3dmodel001.jpg',
        '#F5CA7A',
        '2023-03-14 18:20:03',
        'Iphone XR — новейший флагманский смартфон Apple, предлагающий сочетание передовых технологий и стильного дизайна. Этот телефон с потрясающим 6,1-дюймовым дисплеем Super Retina XDR, тройными задними камерами с улучшенной производительностью при слабом освещении и мощным чипом A15 Bionic обеспечивает исключительный пользовательский опыт. Pro также имеет возможность подключения 5G, обеспечивая молниеносную скорость загрузки и выгрузки, а также аккумулятор с длительным сроком службы, чтобы вы могли оставаться на связи в течение всего дня. Кроме того, он работает на последней версии iOS и включает новые функции, такие как Face ID и Touch ID, обеспечивающие повышенную безопасность и удобство. iPhone 13 Pro — это незаменимое устройство для всех, кто ищет высокопроизводительный стильный смартфон с новейшими функциями и технологиями.',
        6,
        154,
        'https://object.pscloud.io/cms/cms/Photo/img_0_77_1742_0_1.jpg',
        'IPhone XR',
        49990,
        4.5,
        1,
        3347035478233242,
        'https://youtu.be/NOPNWo7tUgg',
        1, 1, null, 1, '03.03.20');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (40, '#F5CA7A', 154, 49990, 20);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (40, '1', 'simCard'),
       (40, '128', 'memoryOfPhone'),
       (40, '3', 'ramOfPhone');

insert into subproduct_images(id, image_url)
values (40, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_1742_0_1.jpg'),
       (40, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_1742_0.jpg'),
       (40, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_1742_1.jpg'),
       (40, 'https://object.pscloud.io/cms/cms/Photo/img_0_77_1742_2.jpg');

insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)
VALUES (21,
        'https://softech.kg/image/catalog/Products/Notebook/Apple/Pro%20M2/5.jpg',
        '#CCCCCC',
        '2023-03-15 18:20:03',
        'MacBook Pro 13 Pro — это мощный и универсальный ноутбук от Apple, разработанный для профессионалов и опытных пользователей. Этот ноутбук с потрясающим 14-дюймовым дисплеем Retina и быстрым процессором Apple M1 Pro обеспечивает исключительное удобство работы, независимо от того, работаете ли вы над сложными задачами или используете ресурсоемкие приложения. MacBook Pro также оснащен последней версией macOS, обеспечивающей плавный и интуитивно понятный пользовательский интерфейс, а также сенсорной панелью — сенсорной полосой стекла над клавиатурой, обеспечивающей быстрый доступ к распространенным инструментам и функциям. Кроме того, он имеет долговечную батарею, обеспечивающую до 14 часов работы без подзарядки, и поставляется с быстрым и надежным хранилищем SSD. MacBook Pro — идеальный ноутбук для тех, кто ищет мощное, универсальное и стильное устройство для работы или личного использования.',
        8,
        36,
        'https://object.pscloud.io/cms/cms/Photo/img_0_62_2592_2_1.jpg',
        'Apple MacBook Pro 13',
        189990,
        0,
        0,
        243524345453,
        'https://youtu.be/PS2bM9cLv-I',
        1, 2, null, 8, '03.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (41, '#CCCCCC', 36, 189990, 21);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (41, 'Apple M2 Pro', 'laptopCPU'),
       (41, '3024×1964', 'screenResolutionLaptop'),
       (41, '8', 'videoCardMemory'),
       (41, '32', 'ramLaptop'),
       (41, '14', 'screenSizeLaptop');

insert into subproduct_images(id, image_url)
values (41, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2592_2_1.jpg'),
       (41, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2592_0_1.jpg'),
       (41, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2592_1_1.jpg');

insert into products(id, pdf, color, create_at, description, guarantee, product_count, product_image, product_name,
                     product_price,
                     product_rating, product_status, product_vendor_code, video_review, brand_id, category_id,
                     discount_id, sub_category_id, date_of_issue)

VALUES (22,
        'https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/S/aplus-media/vc/7e935bc1-c4e2-4309-9e41-c2adb6c33ab4.__CR0,0,970,300_PT0_SX970_V1___.jpg',
        '#CCCCCC',
        '2023-03-17 18:20:03',
        'Lenovo IdeaPad 3 — это недорогой ноутбук с отличной производительностью и функциями для повседневного использования. Благодаря быстрому процессору Intel Core i5 и дисплею Full HD этот ноутбук обеспечивает плавную и быструю работу, независимо от того, работаете ли вы, просматриваете веб-страницы или смотрите видео. VivoBook 15 также отличается элегантным и стильным дизайном, тонким и легким форм-фактором, который позволяет легко носить его с собой и использовать в дороге. Кроме того, он имеет аккумулятор с длительным сроком службы, обеспечивающий до 6 часов работы без подзарядки, а также быстрые и надежные варианты хранения. Asus VivoBook 15 — отличный выбор для тех, кто ищет недорогой ноутбук, обеспечивающий производительность и функции, необходимые для повседневного использования.',
        5,
        34,
        'https://object.pscloud.io/cms/cms/Photo/img_0_62_2765_0_1.jpg',
        'Lenovo IdeaPad 3',
        59990,
        0,
        0,
        13987985,
        'https://youtu.be/NvVFETD72pg',
        5, 2, null, 7, '03.03.23');

insert into subproducts(id, color, count_of_subproduct, price, product_id)
values (42, '#000000', 87, 69990, 22);

insert into characteristics_subproduct(id, characteristics_value, characteristics_key)
values (42, 'Intel Core i7', 'laptopCPU'),
       (42, '1920х1080', 'screenResolutionLaptop'),
       (42, '8', 'videoCardMemory'),
       (42, '8', 'ramLaptop'),
       (42, '15.6', 'screenSizeLaptop');

insert into subproduct_images(id, image_url)
values (42, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2765_0_1.jpg'),
       (42, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2765_9_1.jpg'),
       (42, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2765_8_1.jpg'),
       (42, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2765_3_1.jpg'),
       (42, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2765_4_1.jpg'),
       (42, 'https://object.pscloud.io/cms/cms/Photo/img_0_62_2765_5_1.jpg');

insert into orders(id, address, count_of_product, date_of_order, delivery_status, email, first_name, last_name,
                   order_number, order_status, order_type, payment, phone_number, total_discount, total_sum, user_id)
values (1, 'г.Бишкек, Токтоналиева, 145/7 кв 24, дом 5', 3, '2022-09-13 18:20:03', 'WAITING', 'syimyk@gmail.com',
        'Syimyk', 'Ravshanbekov', 0455247, 'IN_PROCESSING', 'DELIVERY', 'CASH', '+996222219743', 15750, 315000, 2),

       (2, 'г.Бишкек, Гражданская, 119', 3, '2023-09-13 18:20:03', 'IN_PROCESS', 'ulukbekkochkorov@gmail.com',
        'Ulukbek',
        'Kochkorov', 455237, 'IN_PROCESSING', 'DELIVERY', 'CASH', '+996999219743', 249570, 270910, 3),

       (3, 'г.Бишкек, Чуй 34 кв 23', 3, '2021-09-13 18:20:03', 'WAITING', 'mirgul@gmail.com', 'Mirgul', 'Abdinazarova',
        466247, 'IN_PROCESSING', 'PICKUP', 'PAYMENT_WITH_CARD', '+996222219743', 204387, 217900, 4),

       (4, 'г.Бишкек, Токтогулова, 123 кв 67', 3, '2020-09-13 18:20:03', 'IN_PROCESS', 'baktygul@gmail.com', 'Baktygul',
        'Kushtarbek kyzy', 455289, 'IN_PROCESSING', 'DELIVERY', 'CASH', '+996222219743', 215076, 230675, 5),

       (5, 'г.Бишкек, Ахунбаева, 47 кв 12, дом 8', 3, '2023-09-13 18:20:03', 'WAITING', 'nursultan@gmail.com',
        'Nursultan',
        'Zhumataev', 4545277, 'IN_PROCESSING', 'PICKUP', 'PAYMENT_OFFLINE_WITH_CARD', '+996222219743', 239344, 240657,
        6),

       (6, 'г.Бишкек, Гражданская, 119', 3, '2022-09-13 18:20:03', 'WAITING', 'alisher@gmail.com',
        'Alisher', 'Zhumanov', 0455247, 'IN_PROCESSING', 'DELIVERY', 'CASH', '+996222219743', 34521, 234567, 7),

       (7, 'г.Бишкек, Токтоналиева, 145/7 кв 24, дом 5', 3, '2023-09-13 18:20:03', 'IN_PROCESS', 'albina@gmail.com',
        'Albina',
        'Azamatova', 455237, 'IN_PROCESSING', 'DELIVERY', 'CASH', '+996999219743', 249570, 270910, 8),

       (8, 'г.Бишкек, Токтогулова, 123 кв 67', 3, '2021-09-13 18:20:03', 'WAITING', 'malik@gmail.com', 'Malik',
        'Kaamilov',
        466247, 'IN_PROCESSING', 'PICKUP', 'PAYMENT_WITH_CARD', '+996222219743', 204387, 217900, 9),

       (9, 'г.Бишкек, Чуй 34 кв 23', 3, '2020-09-13 18:20:03', 'IN_PROCESS', 'nurtilek@gmail.com', 'nurtilek',
        'Maksatbek uulu', 455289, 'IN_PROCESSING', 'DELIVERY', 'CASH', '+996222219743', 215076, 230675, 10),

       ----------------------------------------------------------------------------------------------------------------------------

       (10, 'г.Бишкек, Токтоналиева, 145/7 кв 24, дом 5', 3, '2022-09-13 18:20:03', 'WAITING', 'syimyk@gmail.com',
        'Syimyk', 'Ravshanbekov', 0455247, 'CANCEL', 'DELIVERY', 'CASH', '+996222219743', 15750, 315000, 2),

       (11, 'г.Бишкек, Гражданская, 119', 3, '2023-09-13 18:20:03', 'IN_PROCESS', 'ulukbekkochkorov@gmail.com',
        'Ulukbek',
        'Kochkorov', 455237, 'CANCEL', 'DELIVERY', 'CASH', '+996999219743', 249570, 270910, 3),

       (12, 'г.Бишкек, Чуй 34 кв 23', 3, '2021-09-13 18:20:03', 'WAITING', 'mirgul@gmail.com', 'Mirgul', 'Abdinazarova',
        466247, 'CANCEL', 'PICKUP', 'PAYMENT_WITH_CARD', '+996222219743', 204387, 217900, 4),

       (13, 'г.Бишкек, Токтогулова, 123 кв 67', 3, '2020-09-13 18:20:03', 'IN_PROCESS', 'baktygul@gmail.com',
        'Baktygul',
        'Kushtarbek kyzy', 455289, 'CANCEL', 'DELIVERY', 'CASH', '+996222219743', 215076, 230675, 5),

       (14, 'г.Бишкек, Ахунбаева, 47 кв 12, дом 8', 3, '2023-09-13 18:20:03', 'WAITING', 'nursultan@gmail.com',
        'Nursultan',
        'Zhumataev', 4545277, 'CANCEL', 'PICKUP', 'PAYMENT_OFFLINE_WITH_CARD', '+996222219743', 239344, 240657, 6),

       (15, 'г.Бишкек, Гражданская, 119', 3, '2022-09-13 18:20:03', 'WAITING', 'alisher@gmail.com',
        'Alisher', 'Zhumanov', 0455247, 'CANCEL', 'DELIVERY', 'CASH', '+996222219743', 34521, 234567, 7),

       (16, 'г.Бишкек, Токтоналиева, 145/7 кв 24, дом 5', 3, '2023-09-13 18:20:03', 'IN_PROCESS', 'albina@gmail.com',
        'Albina',
        'Azamatova', 455237, 'CANCEL', 'DELIVERY', 'CASH', '+996999219743', 249570, 270910, 8),

       (17, 'г.Бишкек, Токтогулова, 123 кв 67', 3, '2021-09-13 18:20:03', 'WAITING', 'malik@gmail.com', 'Malik',
        'Kaamilov',
        466247, 'CANCEL', 'PICKUP', 'PAYMENT_WITH_CARD', '+996222219743', 204387, 217900, 9),

       (18, 'г.Бишкек, Чуй 34 кв 23', 3, '2020-09-13 18:20:03', 'IN_PROCESS', 'nurtilek@gmail.com', 'nurtilek',
        'Maksatbek uulu', 455289, 'CANCEL', 'DELIVERY', 'CASH', '+996222219743', 215076, 230675, 10),

       ----------------------------------------------------------------------------------------------------------------------------

       (19, 'г.Бишкек, Токтоналиева, 145/7 кв 24, дом 5', 3, '2022-09-13 18:20:03', 'WAITING', 'syimyk@gmail.com',
        'Syimyk', 'Ravshanbekov', 0455247, 'DELIVERED', 'DELIVERY', 'CASH', '+996222219743', 15750, 315000, 2),

       (20, 'г.Бишкек, Гражданская, 119', 3, '2023-09-13 18:20:03', 'IN_PROCESS', 'ulukbekkochkorov@gmail.com',
        'Ulukbek',
        'Kochkorov', 455237, 'DELIVERED', 'DELIVERY', 'CASH', '+996999219743', 249570, 270910, 3),

       (21, 'г.Бишкек, Чуй 34 кв 23', 3, '2021-09-13 18:20:03', 'WAITING', 'mirgul@gmail.com', 'Mirgul', 'Abdinazarova',
        466247, 'DELIVERED', 'PICKUP', 'PAYMENT_WITH_CARD', '+996222219743', 204387, 217900, 4),

       (22, 'г.Бишкек, Токтогулова, 123 кв 67', 3, '2020-09-13 18:20:03', 'IN_PROCESS', 'baktygul@gmail.com',
        'Baktygul',
        'Kushtarbek kyzy', 455289, 'DELIVERED', 'DELIVERY', 'CASH', '+996222219743', 215076, 230675, 5),

       (23, 'г.Бишкек, Ахунбаева, 47 кв 12, дом 8', 3, '2023-09-13 18:20:03', 'WAITING', 'nursultan@gmail.com',
        'Nursultan',
        'Zhumataev', 4545277, 'DELIVERED', 'PICKUP', 'PAYMENT_OFFLINE_WITH_CARD', '+996222219743', 239344, 240657, 6),

       (24, 'г.Бишкек, Гражданская, 119', 3, '2022-09-13 18:20:03', 'WAITING', 'alisher@gmail.com',
        'Alisher', 'Zhumanov', 0455247, 'DELIVERED', 'DELIVERY', 'CASH', '+996222219743', 34521, 234567, 7),

       (25, 'г.Бишкек, Токтоналиева, 145/7 кв 24, дом 5', 3, '2023-09-13 18:20:03', 'IN_PROCESS', 'albina@gmail.com',
        'Albina',
        'Azamatova', 455237, 'DELIVERED', 'DELIVERY', 'CASH', '+996999219743', 249570, 270910, 8),

       (26, 'г.Бишкек, Токтогулова, 123 кв 67', 3, '2021-09-13 18:20:03', 'WAITING', 'malik@gmail.com', 'Malik',
        'Kaamilov',
        466247, 'DELIVERED', 'PICKUP', 'PAYMENT_WITH_CARD', '+996222219743', 204387, 217900, 9),

       (27, 'г.Бишкек, Чуй 34 кв 23', 3, '2020-09-13 18:20:03', 'IN_PROCESS', 'nurtilek@gmail.com', 'nurtilek',
        'Maksatbek uulu', 455289, 'DELIVERED', 'DELIVERY', 'CASH', '+996222219743', 215076, 230675, 10),

       ----------------------------------------------------------------------------------------------------------------------------

       (28, 'г.Бишкек, Токтоналиева, 145/7 кв 24, дом 5', 3, '2022-09-13 18:20:03', 'WAITING', 'syimyk@gmail.com',
        'Syimyk', 'Ravshanbekov', 0455247, 'ON_THE_WAY', 'DELIVERY', 'CASH', '+996222219743', 15750, 315000, 2),

       (29, 'г.Бишкек, Гражданская, 119', 3, '2023-09-13 18:20:03', 'IN_PROCESS', 'ulukbekkochkorov@gmail.com',
        'Ulukbek',
        'Kochkorov', 455237, 'ON_THE_WAY', 'DELIVERY', 'CASH', '+996999219743', 249570, 270910, 3),

       (30, 'г.Бишкек, Чуй 34 кв 23', 3, '2021-09-13 18:20:03', 'WAITING', 'mirgul@gmail.com', 'Mirgul', 'Abdinazarova',
        466247, 'ON_THE_WAY', 'PICKUP', 'PAYMENT_WITH_CARD', '+996222219743', 204387, 217900, 4),

       (31, 'г.Бишкек, Токтогулова, 123 кв 67', 3, '2020-09-13 18:20:03', 'IN_PROCESS', 'baktygul@gmail.com',
        'Baktygul',
        'Kushtarbek kyzy', 455289, 'ON_THE_WAY', 'DELIVERY', 'CASH', '+996222219743', 215076, 230675, 5),

       (32, 'г.Бишкек, Ахунбаева, 47 кв 12, дом 8', 3, '2023-09-13 18:20:03', 'WAITING', 'nursultan@gmail.com',
        'Nursultan',
        'Zhumataev', 4545277, 'ON_THE_WAY', 'PICKUP', 'PAYMENT_OFFLINE_WITH_CARD', '+996222219743', 239344, 240657, 6),

       (33, 'г.Бишкек, Гражданская, 119', 3, '2022-09-13 18:20:03', 'WAITING', 'alisher@gmail.com',
        'Alisher', 'Zhumanov', 0455247, 'ON_THE_WAY', 'DELIVERY', 'CASH', '+996222219743', 34521, 234567, 7),

       (34, 'г.Бишкек, Токтоналиева, 145/7 кв 24, дом 5', 3, '2023-09-13 18:20:03', 'IN_PROCESS', 'albina@gmail.com',
        'Albina',
        'Azamatova', 455237, 'ON_THE_WAY', 'DELIVERY', 'CASH', '+996999219743', 249570, 270910, 8),

       (35, 'г.Бишкек, Токтогулова, 123 кв 67', 3, '2021-09-13 18:20:03', 'WAITING', 'malik@gmail.com', 'Malik',
        'Kaamilov',
        466247, 'ON_THE_WAY', 'PICKUP', 'PAYMENT_WITH_CARD', '+996222219743', 204387, 217900, 9),

       (36, 'г.Бишкек, Чуй 34 кв 23', 3, '2020-09-13 18:20:03', 'IN_PROCESS', 'nurtilek@gmail.com', 'nurtilek',
        'Maksatbek uulu', 455289, 'ON_THE_WAY', 'DELIVERY', 'CASH', '+996222219743', 215076, 230675, 10),

       ----------------------------------------------------------------------------------------------------------------------------

       (37, 'г.Бишкек, Токтоналиева, 145/7 кв 24, дом 5', 3, '2022-09-13 18:20:03', 'WAITING', 'syimyk@gmail.com',
        'Syimyk', 'Ravshanbekov', 0455247, 'ORDER_READY', 'DELIVERY', 'CASH', '+996222219743', 15750, 315000, 2),

       (38, 'г.Бишкек, Гражданская, 119', 3, '2023-09-13 18:20:03', 'IN_PROCESS', 'ulukbekkochkorov@gmail.com',
        'Ulukbek',
        'Kochkorov', 455237, 'ORDER_READY', 'DELIVERY', 'CASH', '+996999219743', 249570, 270910, 3),

       (39, 'г.Бишкек, Чуй 34 кв 23', 3, '2021-09-13 18:20:03', 'WAITING', 'mirgul@gmail.com', 'Mirgul', 'Abdinazarova',
        466247, 'ORDER_READY', 'PICKUP', 'PAYMENT_WITH_CARD', '+996222219743', 204387, 217900, 4),

       (40, 'г.Бишкек, Токтогулова, 123 кв 67', 3, '2020-09-13 18:20:03', 'IN_PROCESS', 'baktygul@gmail.com',
        'Baktygul',
        'Kushtarbek kyzy', 455289, 'ORDER_READY', 'DELIVERY', 'CASH', '+996222219743', 215076, 230675, 5),

       (41, 'г.Бишкек, Ахунбаева, 47 кв 12, дом 8', 3, '2023-09-13 18:20:03', 'WAITING', 'nursultan@gmail.com',
        'Nursultan',
        'Zhumataev', 4545277, 'ORDER_READY', 'PICKUP', 'PAYMENT_OFFLINE_WITH_CARD', '+996222219743', 239344, 240657, 6),

       (42, 'г.Бишкек, Гражданская, 119', 3, '2022-09-13 18:20:03', 'WAITING', 'alisher@gmail.com',
        'Alisher', 'Zhumanov', 0455247, 'ORDER_READY', 'DELIVERY', 'CASH', '+996222219743', 34521, 234567, 7),

       (43, 'г.Бишкек, Токтоналиева, 145/7 кв 24, дом 5', 3, '2023-09-13 18:20:03', 'IN_PROCESS', 'albina@gmail.com',
        'Albina',
        'Azamatova', 455237, 'ORDER_READY', 'DELIVERY', 'CASH', '+996999219743', 249570, 270910, 8),

       (44, 'г.Бишкек, Токтогулова, 123 кв 67', 3, '2021-09-13 18:20:03', 'WAITING', 'malik@gmail.com', 'Malik',
        'Kaamilov',
        466247, 'ORDER_READY', 'PICKUP', 'PAYMENT_WITH_CARD', '+996222219743', 204387, 217900, 9),

       (45, 'г.Бишкек, Чуй 34 кв 23', 3, '2020-09-13 18:20:03', 'IN_PROCESS', 'nurtilek@gmail.com', 'nurtilek',
        'Maksatbek uulu', 455289, 'ORDER_READY', 'DELIVERY', 'CASH', '+996222219743', 215076, 230675, 10),

       ----------------------------------------------------------------------------------------------------------------------------

       (46, 'г.Бишкек, Токтоналиева, 145/7 кв 24, дом 5', 3, '2022-09-13 18:20:03', 'WAITING', 'syimyk@gmail.com',
        'Syimyk', 'Ravshanbekov', 0455247, 'WAITING', 'DELIVERY', 'CASH', '+996222219743', 15750, 315000, 2),

       (47, 'г.Бишкек, Гражданская, 119', 3, '2023-09-13 18:20:03', 'IN_PROCESS', 'ulukbekkochkorov@gmail.com',
        'Ulukbek',
        'Kochkorov', 455237, 'WAITING', 'DELIVERY', 'CASH', '+996999219743', 249570, 270910, 3),

       (48, 'г.Бишкек, Чуй 34 кв 23', 3, '2021-09-13 18:20:03', 'WAITING', 'mirgul@gmail.com', 'Mirgul', 'Abdinazarova',
        466247, 'WAITING', 'PICKUP', 'PAYMENT_WITH_CARD', '+996222219743', 204387, 217900, 4),

       (49, 'г.Бишкек, Токтогулова, 123 кв 67', 3, '2020-09-13 18:20:03', 'IN_PROCESS', 'baktygul@gmail.com',
        'Baktygul',
        'Kushtarbek kyzy', 455289, 'WAITING', 'DELIVERY', 'CASH', '+996222219743', 215076, 230675, 5),

       (50, 'г.Бишкек, Ахунбаева, 47 кв 12, дом 8', 3, '2023-09-13 18:20:03', 'WAITING', 'nursultan@gmail.com',
        'Nursultan',
        'Zhumataev', 4545277, 'WAITING', 'PICKUP', 'PAYMENT_OFFLINE_WITH_CARD', '+996222219743', 239344, 240657, 6),

       (51, 'г.Бишкек, Гражданская, 119', 3, '2022-09-13 18:20:03', 'WAITING', 'alisher@gmail.com',
        'Alisher', 'Zhumanov', 0455247, 'WAITING', 'DELIVERY', 'CASH', '+996222219743', 34521, 234567, 7),

       (52, 'г.Бишкек, Токтоналиева, 145/7 кв 24, дом 5', 3, '2023-03-13 18:20:03', 'IN_PROCESS', 'albina@gmail.com',
        'Albina',
        'Azamatova', 455237, 'WAITING', 'DELIVERY', 'CASH', '+996999219743', 249570, 270910, 8),

       (53, 'г.Бишкек, Токтогулова, 123 кв 67', 3, '2023-03-21 18:20:03', 'WAITING', 'malik@gmail.com', 'Malik',
        'Kaamilov',
        466247, 'WAITING', 'PICKUP', 'PAYMENT_WITH_CARD', '+996222219743', 204387, 217900, 9),

       (54, 'г.Бишкек, Чуй 34 кв 23', 3, '2020-09-13 18:20:03', 'IN_PROCESS', 'nurtilek@gmail.com', 'nurtilek',
        'Maksatbek uulu', 455289, 'WAITING', 'DELIVERY', 'CASH', '+996222219743', 215076, 230675, 10);


insert into orders_subproducts(subproduct_id, order_id)
values (1, 1),
       (2, 1),
       (3, 1),
       (4, 2),
       (5, 2),
       (6, 2),
       (7, 3),
       (8, 3),
       (9, 3),
       (10, 4),
       (11, 4),
       (12, 4),
       (13, 5),
       (14, 5),
       (15, 5);

insert into user_basket_list(user_id, count_of_product, subproduct_id)
values (2, 1, 1),
       (2, 1, 2),
       (2, 1, 3);

insert into users_compare_products_list(user_id, compare_products_list_id)
values (2, 1),
       (2, 2),
       (2, 3),
       (2, 4),
       (2, 23),
       (2, 6),
       (2, 8),
       (2, 9),
       (2, 11),
       (2, 12),
       (2, 13),
       (2, 14),
       (2, 15);

insert into users_favorites_list(user_id, favorites_list_id)
values (2, 1),
       (2, 2),
       (2, 3),
       (2, 4);

insert into users_viewed_products_list(user_id, viewed_products_list_id)
values (2, 1),
       (2, 2),
       (2, 3),
       (2, 4);

insert into feedbacks(id, email, first_name, last_name, phone_number, text)
values (1, 'megaline@gmail.com', 'Aibek', 'Abdurasulov', '+996123453621', 'my first feedback'),
       (2, 'brand@gmail.com', 'Aizada', 'Abdurasulova', '+996123453634', 'second feedback'),
       (3, 'batken@gmail.com', 'Gapyr', 'Agai', '+996123453622', 'third feedback'),
       (4, 'kgz@gmail.com', 'Uson', 'Rasulov', '+996123453424', 'forth feedback'),
       (5, 'shoro@gmail.com', 'Balanca', 'Balanchaev', '+996123453424', 'fifth feedback');

insert into reviews(id, product_grade, response_of_review, review_time, status_of_response, user_review, product_id,
                    user_id)
values (1, 4, null, '2023-03-13 18:20:03', false, '- Размер (разумный - достаточно большой для чтения/просмотра контента, но не чрезмерный)
- Камера (первое время режимом "мультикадр" был приятно удивлён + мегапикселей не пожалели на основную камеру, зум работает увереннее, чем у конкурентов)
- Экран (приятная цветопередача, читать комфортно, повышенная герцовка в первые разы восхищала).', 20, 7),
       (2, 4, null, '2023-03-13 18:20:03', false, '- Размер (разумный - достаточно большой для чтения/просмотра контента, но не чрезмерный)
- Камера (первое время режимом "мультикадр" был приятно удивлён + мегапикселей не пожалели на основную камеру, зум работает увереннее, чем у конкурентов)
- Экран (приятная цветопередача, читать комфортно, повышенная герцовка в первые разы восхищала).', 20, 3),
       (3, 5, 'Добрый день! Благодарим Вас за отзыв, рады быть полезными. Спасибо, что выбираете нас. Хорошего дня!',
        '2023-09-13 18:20:03', true, '- Размер (разумный - достаточно большой для чтения/просмотра контента, но не чрезмерный)
- Камера (первое время режимом "мультикадр" был приятно удивлён + мегапикселей не пожалели на основную камеру, зум работает увереннее, чем у конкурентов)
- Экран (приятная цветопередача, читать комфортно, повышенная герцовка в первые разы восхищала).', 20, 4),
       (4, 4, 'Добрый день! Благодарим Вас за отзыв, рады быть полезными. Спасибо, что выбираете нас. Хорошего дня!',
        '2023-09-13 18:20:03', true, '- Размер (разумный - достаточно большой для чтения/просмотра контента, но не чрезмерный)
- Камера (первое время режимом "мультикадр" был приятно удивлён + мегапикселей не пожалели на основную камеру, зум работает увереннее, чем у конкурентов)
- Экран (приятная цветопередача, читать комфортно, повышенная герцовка в первые разы восхищала).', 20, 5),
       (5, 4, 'Добрый день! Благодарим Вас за отзыв, рады быть полезными. Спасибо, что выбираете нас. Хорошего дня!',
        '2023-09-13 18:20:03', true, '- Размер (разумный - достаточно большой для чтения/просмотра контента, но не чрезмерный)
- Камера (первое время режимом "мультикадр" был приятно удивлён + мегапикселей не пожалели на основную камеру, зум работает увереннее, чем у конкурентов)
- Экран (приятная цветопередача, читать комфортно, повышенная герцовка в первые разы восхищала).', 20, 6);

insert into review_images(id, image_url)
values (2, 'https://apollo-singapore.akamaized.net/v1/files/09g28lmow8kf-ID/image'),
       (2, 'https://apollo-singapore.akamaized.net/v1/files/09g28lmow8kf-ID/image');

insert into banners(id, image)
values (1, 'https://gadgetarium-b7.s3.eu-central-1.amazonaws.com/1679820708493banner iphone 14 pro.png'),
       (5, 'https://gadgetarium-b7.s3.eu-central-1.amazonaws.com/1679821600536banner samsung.png'),
       (2, 'https://gadgetarium-b7.s3.eu-central-1.amazonaws.com/1679821174328banner iphone 13 pro.png'),
       (3, 'https://gadgetarium-b7.s3.eu-central-1.amazonaws.com/1679821297764banner apple watch.png'),
       (4, 'https://gadgetarium-b7.s3.eu-central-1.amazonaws.com/1679821454995banner apple ipad.png');

insert into users_order_history_list(user_id, order_history_list_id)
values (2, 1),
       (2, 2),
       (2, 3),
       (2, 4),
       (2, 5),
       (2, 6),
       (2, 8),
       (2, 9),
       (2, 10),
       (2, 11),
       (2, 12),
       (2, 13),
       (2, 14),
       (2, 15),
       (2, 16),
       (2, 17),
       (2, 18),
       (2, 19),
       (2, 20),
       (2, 21),
       (2, 22),
       (2, 23);