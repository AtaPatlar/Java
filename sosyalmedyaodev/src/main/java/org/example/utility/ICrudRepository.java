package org.example.utility;

import java.util.List;

public interface ICrudRepository<T,ID>{

                public void save(T t);
                public void delete(T t);
                public void update(T  t);


                public<T> List<T> getAll(Class<T> t);
                public T getById(Class<T> entityClass,ID id);



}
