package com.example.restaurant.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDbRepositoryIfs<T> {

    // 타입에 대한 엔티티데이터를 찾아서 리턴?
    Optional<T> finById(int index);
    T save(T entity);   // 저장하는 메서드
    void deleteById(int index); // 삭제 메서드
    List<T> findAll();  // 전체를 리턴
}
