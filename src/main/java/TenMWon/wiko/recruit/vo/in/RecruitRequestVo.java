package TenMWon.wiko.recruit.vo.in;

import TenMWon.wiko.recruit.entity.EmploymentType;
import TenMWon.wiko.recruit.entity.IndustryType;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RecruitRequestVo {

    private String title;
    private String payType;
    private Long pay;
    private EmploymentType employmentType;
    private String workingPeriod;
    private String workingHours;
    private String deadline;
    private String qualification;
    private String responsibilities;
    private String preferredQualifications;
    private String imgUrl;
    private String company;
    private String jobName;
    private String companyInfo;
    private String location;
    private IndustryType industryType;
    private String owner;
    private String phone;
    private String email;
    private Boolean local;
    private String lang;
}
