package com.ToDO.To.Do.App.DataBase;

import org.springframework.data.repository.CrudRepository;

public interface DataBaseRepository extends CrudRepository<DatabaseTable, Long> {
}
