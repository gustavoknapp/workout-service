create table workout (
  id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  name VARCHAR(255)
); 

create table workout_variation(
  id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  variation_name VARCHAR(255),
  workout_id BIGINT REFERENCES workout(id) 
);

create table variation_level(
  id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  level_name int, --1, 2, 3
  number_of_sets int,
  number_of_reps int,
  variation_id BIGINT REFERENCES workout_variation(id)
);

create table workout_log(
  id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  variation_id BIGINT REFERENCES workout_variation(id),
  wokrout_date TIMESTAMP
);

create table workout_log_sets(
  id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  set_number int,
  reps int,
  workout_log_id BIGINT REFERENCES workout_log(id)
);