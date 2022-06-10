package team2.api.mobile.gplx.commondata;

import java.util.List;
import java.util.Optional;

import team2.api.mobile.gplx.commondata.model.AbstractEntity;

public interface GenericService<T extends AbstractEntity, ID> {

	List<T> findAll();
	Optional<T> findById(ID id);
	T save(T entity);
	T update(T entity);
	void deleteById(ID id);
}
