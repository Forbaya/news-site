## Tietokannan scheema

 Schema |       Name        | Type       
--------+-------------------+------
 public | account           | table
 public | account_articles  | table
 public | article           | table
 public | category          | table
 public | category_articles | table
 public | image             | table

### Table "public.account"
  Column  |          Type          | Modifiers 
----------+------------------------+-----------
 id       | bigint                 | not null
 forename | character varying(255) | 
 password | character varying(255) | 
 surname  | character varying(255) | 
 username | character varying(255) | 
Indexes:
    "account_pkey" PRIMARY KEY, btree (id)
Referenced by:
    TABLE "account_articles" CONSTRAINT "fkgqv7tvh50bbrodt6h44uojbch" FOREIGN KEY (account_id) REFERENCES account(id)

### Table "public.account_articles"
   Column    |  Type  | Modifiers 
-------------+--------+-----------
 account_id  | bigint | not null
 articles_id | bigint | not null
Indexes:
    "uk_e3a04f0hqvs3hpifjl8jusbsa" UNIQUE CONSTRAINT, btree (articles_id)
Foreign-key constraints:
    "fkeq3x7dmu49c1hspkn92l9bb7q" FOREIGN KEY (articles_id) REFERENCES article(id)
    "fkgqv7tvh50bbrodt6h44uojbch" FOREIGN KEY (account_id) REFERENCES account(id)


### Table "public.article"
     Column     |           Type           | Modifiers 
----------------+--------------------------+-----------
 id             | bigint                   | not null
 account        | bytea                    | 
 body_text      | character varying(15000) | 
 category       | bytea                    | 
 image          | bytea                    | 
 lead_paragraph | character varying(1000)  | 
 release_date   | bytea                    | 
 title          | character varying(255)   | 
Indexes:
    "article_pkey" PRIMARY KEY, btree (id)
Referenced by:
    TABLE "category_articles" CONSTRAINT "fk37mapeyjnhflee6egaitw56e8" FOREIGN KEY (articles_id) REFERENCES article(id)
    TABLE "account_articles" CONSTRAINT "fkeq3x7dmu49c1hspkn92l9bb7q" FOREIGN KEY (articles_id) REFERENCES article(id)


### Table "public.category"
 Column |          Type          | Modifiers 
--------+------------------------+-----------
 id     | bigint                 | not null
 name   | character varying(255) | 
Indexes:
    "category_pkey" PRIMARY KEY, btree (id)
Referenced by:
    TABLE "category_articles" CONSTRAINT "fkh62bbl9cduu2m9o3t16igci4n" FOREIGN KEY (category_id) REFERENCES category(id)

### Table "public.category_articles"
   Column    |  Type  | Modifiers 
-------------+--------+-----------
 category_id | bigint | not null
 articles_id | bigint | not null
Indexes:
    "uk_5qffah1u9i4u4do0uytcaew8o" UNIQUE CONSTRAINT, btree (articles_id)
Foreign-key constraints:
    "fk37mapeyjnhflee6egaitw56e8" FOREIGN KEY (articles_id) REFERENCES article(id)
    "fkh62bbl9cduu2m9o3t16igci4n" FOREIGN KEY (category_id) REFERENCES category(id)


### Table "public.image"
     Column     |          Type          | Modifiers 
----------------+------------------------+-----------
 id             | bigint                 | not null
 content        | oid                    | 
 content_length | bigint                 | 
 content_type   | character varying(255) | 
 name           | character varying(255) | 
Indexes:
    "image_pkey" PRIMARY KEY, btree (id)
