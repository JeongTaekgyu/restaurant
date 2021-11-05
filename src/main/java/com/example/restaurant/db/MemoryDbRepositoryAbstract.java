package com.example.restaurant.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// 추상화된 MemoryDbRepository 가 만들어짐
abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T>{
                                        // 이걸 제네릭 타입에 와일드카드를? 걸었다고 얘기하네..
    // 데이터를 저장할 ArrayList
    private final List<T> db = new ArrayList<>();
    private int index = 0;

    @Override
    public Optional<T> finById(int index) {
        // getIndex의 값이 index의 값과 동일하다의 findFirst를 리턴
        return db.stream().filter(it -> it.getIndex() == index).findFirst();
        // filter는 db.stream() 에 들어있는 Type에 대한 부분, getIndex()는 MemoryDbEntity 에 정의된 index
    }

    @Override
    public T save(T entity) {
        var optionalEntity = db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();
                        // entity.getIndex()를 가지고 db에서 첫번째부터 쭉 돌다가
                        // 동일한게 있으면 이미 있는 데이터가 return이 된다. -> else 문으로 그럼 기존의 인덱스를 꺼내서 새로운 entity에다 셋팅한다
                        // 기존데이터 지우고 새로운 entity를 저장한다.
        if(optionalEntity.isEmpty()){ // db에 데이터가 없는 경우
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;
        } else { // db에 이미 데이터가 있는 경우
            var preIndex = optionalEntity.get().getIndex(); // 이전에
            entity.setIndex(preIndex);  // 이전에 있던 데이터index를 가져와서
            // 새로운 index에다 setIndex

            deleteById(preIndex);   // 이전에 있던 data를 지움
            db.add(entity);
            return entity;
        }
    }

    @Override
    public void deleteById(int index) {
        var optionalEntity = db.stream().filter(it -> it.getIndex() == index).findFirst();

        if(optionalEntity.isPresent()){ // data가 이미 있는 경우
            db.remove(optionalEntity.get());
        }
    }

    @Override
    public List<T> findAll() {
        return db;
    }
}
