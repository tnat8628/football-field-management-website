package vn.iostar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iostar.entity.Field;

@Repository
public interface FieldRepository extends JpaRepository<Field, Integer>{
	//Tìm kiếm theo nội dung tên
	List<Field> findByFieldNameContaining(String name);
	
	Optional<Field> findByFieldName(String name);
}
