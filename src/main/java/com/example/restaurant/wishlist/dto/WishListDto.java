package com.example.restaurant.wishlist.dto;

import com.example.restaurant.db.MemoryDbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false) // 이거 있으니까 saveTest 에서 에러가 없네
public class WishListDto {

    // index를 직접 넣은 이유는 db의 entity가 변경되면 프론트엔드 까지도 변수명을 변경해야 할 수 있기 때문에,
    // 중간에 변환하는 과정만 있으면 되기 떄문에 따로 분리를 시켰다.
    private int index;
    private String title;               // 음식명, 장소명
    private String category;            // 카테고리
    private String address;             // 주소
    private String readAddress;         // 도로명
    private String homePageLink;        // 홈페이지 주소
    private String imageLink;           // 음식, 가게 이미지 주소
    private boolean isVisit;            // 방문여부
    private int visitCount;             // 방문 카운트
    private LocalDateTime lastVisitDate;// 마지막 방문 일자
}
