package com.wero.finalProject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wero.finalProject.domain.UserEntity;
import com.wero.finalProject.dto.response.ListResponseDto;
import com.wero.finalProject.dto.response.ResponseDto;
import com.wero.finalProject.dto.response.feeds.DeleteFeedsResponseDto;
import com.wero.finalProject.dto.response.feeds.ListFeedResponseDto;
import com.wero.finalProject.dto.response.report.ReportResponseDto;
import com.wero.finalProject.dto.response.user.FindUserResponseDto;
import com.wero.finalProject.dto.response.user.UserResponseDto;
import com.wero.finalProject.service.AdminService;
import com.wero.finalProject.service.MainFeedService;
import com.wero.finalProject.service.UserService;

/**
 * @작성자:김선규
 * @작성날짜:2024/05/22
 * @파일명:AdminController
 * @기능:Admin 컨트롤러
 **/

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final AdminService adminService;
    private final MainFeedService mainFeedService;
    private final UserService userService;

    public AdminController(AdminService adminService, MainFeedService mainFeedService, UserService userService) {
        this.adminService = adminService;
        this.mainFeedService = mainFeedService;
        this.userService = userService;

    }

    // 신고된 피드 크기 조회
    @GetMapping("/reports/size")
    public Integer getDistinctReportsByMainFeedSize() {
        return adminService.getDistinctReportsByMainFeedSize();
    }

    // 신고된 피드 조회
    @GetMapping("/reports")
    public ResponseEntity<ListResponseDto<ReportResponseDto>> getDistinctReports(@RequestParam int page,
            @RequestParam int size) {
        try {
            List<ReportResponseDto> reports = adminService.getDistinctReportsByMainFeed(page, size);

            return ListFeedResponseDto.getFeedsSuccess(reports);
        } catch (Exception e) {
            return ListFeedResponseDto.getFeesFail();
        }

    }

    // 신고 피드 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReport(@PathVariable Integer id) {
        try {
            mainFeedService.deleteFeed(id);
            return DeleteFeedsResponseDto.delete();
        } catch (IllegalArgumentException e) {
            return DeleteFeedsResponseDto.deleteFail();
        } catch (Exception e) {
            return ResponseDto.dataBaseError();
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> userSuspension(@PathVariable String userId) {
        return adminService.userSuspension(userId);
    }

    // 정지된 유저 리스트 사이즈
    @GetMapping("/user/suspension/size")
    public Integer getUserSuspensionSize() {
        return adminService.getUserSuspensionSize();
    }

    // 정지 유저 조회
    @GetMapping("/user/suspension")
    public ResponseEntity<ListResponseDto<UserEntity.UserSuspensionDto>> getUserSuspension(@RequestParam int page,
            @RequestParam int size) {

        try {
            List<UserEntity.UserSuspensionDto> supensionUsers = adminService.getUserSuspension(page, size);

            return ListFeedResponseDto.getFeedsSuccess(supensionUsers);
        } catch (Exception e) {
            return ListFeedResponseDto.getFeesFail();
        }
    }

    @GetMapping(value = "/find/prof")
    public ResponseEntity<List<String>> findPic(@AuthenticationPrincipal String userId) {
        List<String> response = userService.findUserPicture(userId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getUser(@AuthenticationPrincipal String userId) {
        try {
            UserResponseDto response = userService.findByUserId(userId);

            return FindUserResponseDto.getUserSuccess(response);

        } catch (Exception e) {
            return FindUserResponseDto.getUserFail();
        }
    }

}
