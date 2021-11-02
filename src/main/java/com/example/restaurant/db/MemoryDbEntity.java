package com.example.restaurant.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemoryDbEntity {   // 모든 데이터베이스를 갖는 애들은 MemoryDbEntity를 상속받을 거다
    protected Integer index;    // int 형으로 하면 db에 0이 들어갈 수 도 있어서 Integer 형으로한다.
}
