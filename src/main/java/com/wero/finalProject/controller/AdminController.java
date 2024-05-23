package com.wero.finalProject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wero.finalProject.dto.response.ListResponseDto;
import com.wero.finalProject.dto.response.ResponseDto;
import com.wero.finalProject.dto.response.feeds.DeleteFeedsResponseDto;
import com.wero.finalProject.dto.response.feeds.ListFeedResponseDto;
import com.wero.finalProject.dto.response.report.ReportResponseDto;
import com.wero.finalProject.service.AdminService;
import com.wero.finalProject.service.MainFeedService;

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

    public AdminController(AdminService adminService, MainFeedService mainFeedService) {
        this.adminService = adminService;
        this.mainFeedService = mainFeedService;

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

}
