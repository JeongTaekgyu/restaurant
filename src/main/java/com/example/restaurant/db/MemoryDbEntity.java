package com.example.restaurant.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemoryDbEntity {   // 모든 데이터베이스를 갖는 애들은 MemoryDbEntity를 상속받을 거다
    protected int index;
}
