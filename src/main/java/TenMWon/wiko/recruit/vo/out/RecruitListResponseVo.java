package TenMWon.wiko.recruit.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class RecruitListResponseVo {

    private Long id;
    private String company;
    private String title;
    private String location;
    private String payType;
    private Long pay;
    private String imgUrl;

}
