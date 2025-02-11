package TenMWon.wiko.recruit.controller;

import TenMWon.wiko.common.entity.BaseResponse;
import TenMWon.wiko.common.entity.BaseResponseStatus;
import TenMWon.wiko.recruit.dto.in.RecruitRequestDto;
import TenMWon.wiko.recruit.dto.out.RecruitListResponseDto;
import TenMWon.wiko.recruit.service.RecruitService;
import TenMWon.wiko.recruit.vo.in.RecruitRequestVo;
import TenMWon.wiko.recruit.vo.out.RecruitResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/recruit")
public class RecruitController {

    private final RecruitService recruitService;

    @Operation(summary = "Recruit 등록 API", description = "Recruit 등록 API 입니다.", tags = {"Recruit"})
    @PostMapping
    public BaseResponse<Void> createRecruit(
            @RequestBody RecruitRequestVo recruitRequestVo) {
        recruitService.createRecruit(RecruitRequestDto.toDto(recruitRequestVo));
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @Operation(summary = "Recruit List API", description = "최신순으로 일자리 정보를 List로 조회하는 API 입니다.", tags = {"Recruit"})
    @GetMapping("/list")
    public BaseResponse<Page<RecruitListResponseDto>> readRecruitList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<RecruitListResponseDto> recruitListResponseVoList = recruitService.readRecruitList(page, size);
        return new BaseResponse<>(recruitListResponseVoList);
    }

    @Operation(summary = "Recruit 필터링, 검색 API", description = "업종, 지역, 급여별 필터링 조회 및 검색 API 입니다.", tags = {"Recruit"})
    @GetMapping("/filterList")
    public BaseResponse<Page<RecruitListResponseDto>> readFilterRecruitList(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) List<String> industryTypeList,
            @RequestParam(required = false) String startAddress,
            @RequestParam(required = false) String endAddress,
            @RequestParam(required = false) Long minPay,
            @RequestParam(required = false) Long maxPay,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RecruitListResponseDto> result = recruitService.readFilterRecruitListWithSearch(
                keyword, industryTypeList, startAddress, endAddress, minPay, maxPay, pageable
        );
        return new BaseResponse<>(result);
    }

//    @Operation(summary = "Recruit 검색 API", description = "recruit 검색내용을 조회하는 API 입니다.", tags = {"Recruit"})
//    @GetMapping("/search")
//    public BaseResponse<Page<RecruitListResponseDto>> readRecruitSearch(
//            @RequestParam String keyword,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size) {
//        Page<RecruitListResponseDto> recruitsSearch = recruitService.readRecruitSearch(keyword, page, size);
//        return new BaseResponse<>(recruitsSearch);
//    }

    @Operation(summary = "Recruit 상세 조회 API", description = "recruitId로 일자리 정보의 상세 내용을 조회하는 API 입니다.", tags = {"Recruit"})
    @GetMapping("/detail")
    public BaseResponse<RecruitResponseVo> readRecruitDetail(@RequestParam Long recruitId) {
        return new BaseResponse<>(recruitService.readRecruitDetail(recruitId).toVo());
    }
}
