package TenMWon.wiko.recruit.entity;

import TenMWon.wiko.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Recruit extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recruitId;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false)
    private Long pay;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmploymentType employmentType;
    @Column(nullable = false)
    private String workingPeriod;
    @Column(nullable = false, length = 100)
    private String workingHours;
    @Column(nullable = false)
    private String deadline;
    @Column(nullable = false, length  = 1000)
    private String qualification;
    @Column(nullable = false, length = 100)
    private String responsibilities;
    @Column(nullable = false, length = 100)
    private String preferredQualifications;

    @Column(nullable = false, length = 100)
    private String imgUrl;
    @Column(nullable = false, length = 100)
    private String company;
    @Column(nullable = false, length = 100)
    private String jobName;
    @Column(nullable = false, length = 1000)
    private String companyInfo;
    @Column(nullable = false, length = 500)
    private String location;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IndustryType industryType;
    @Column(nullable = false, length = 100)
    private String lang;

    @Column(nullable = false, length = 100)
    private String owner;
    @Column(nullable = false, length = 100)
    private String phone;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 100)
    private String payType;
    @Column(nullable = false)
    private Boolean local;

    @Builder
    public Recruit(Long recruitId, String title, Long pay, String payType, Boolean local,
                   EmploymentType employmentType, String workingPeriod,
                   String workingHours, String deadline, String qualification, String lang,
                   String responsibilities, String jobName, String company, String owner, String phone, String email,
                   String imgUrl, String companyInfo, String location, IndustryType industryType, String preferredQualifications) {
        this.recruitId = recruitId;
        this.title = title;
        this.payType = payType;
        this.local = local;
        this.lang = lang;
        this.pay = pay;
        this.employmentType = employmentType;
        this.workingPeriod = workingPeriod;
        this.workingHours = workingHours;
        this.deadline = deadline;
        this.qualification = qualification;
        this.responsibilities = responsibilities;
        this.imgUrl = imgUrl;
        this.jobName = jobName;
        this.company = company;
        this.location = location;
        this.industryType = industryType;
        this.companyInfo = companyInfo;
        this.preferredQualifications = preferredQualifications;
        this.owner = owner;
        this.phone = phone;
        this.email = email;
    }
}
