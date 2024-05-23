package com.wero.finalProject.service.implement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.wero.finalProject.Repository.ReportRepository;
import com.wero.finalProject.domain.ReportEntity;
import com.wero.finalProject.dto.response.report.ReportResponseDto;
import com.wero.finalProject.service.AdminService;

/**
 * @작성자:김선규
 * @작성날짜:2024/05/22
 * @파일명:AdminServiceImpl
 * @기능:Admin 서비스 상세
 **/

@Service("AdminServiceImpl")
public class AdminServiceImpl implements AdminService {

        @Autowired
        private ReportRepository reportRepository;

        // 신고된 피드 조회
        @Override
        public List<ReportResponseDto> getDistinctReportsByMainFeed(int page, int size) {
                Page<ReportEntity> allReportsPage = reportRepository
                                .findAllByOrderByReportedTimeAsc(PageRequest.of(page, size));
                List<ReportEntity> allReports = allReportsPage.getContent();

                Map<Integer, ReportEntity> distinctReportsMap = allReports.stream()
                                .collect(Collectors.toMap(
                                                report -> report.getMainfeedId().getMainfeedId(),
                                                report -> report,
                                                (existing, replacement) -> existing));

                List<ReportResponseDto> reportResponseDtos = distinctReportsMap.values().stream()
                                .map(report -> {
                                        return new ReportResponseDto(
                                                        report.getReportId(),
                                                        report.getMainfeedId().getMainfeedId(),
                                                        report.getMainfeedId().getContent(),
                                                        report.getReportedTime());
                                })
                                .collect(Collectors.toList());

                return reportResponseDtos;
        }

        // // 신고된 피드 삭제
        // @Override
        // public void deleteReport(Integer id) {
        // try {
        // reportRepository.deleteById(id);
        // } catch (Exception e) {
        // throw new RuntimeException("Failed to delete report", e);
        // }
        // }

}
