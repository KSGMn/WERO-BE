package com.wero.finalProject.service;

import java.util.List;

import com.wero.finalProject.dto.response.report.ReportResponseDto;

public interface AdminService {

    List<ReportResponseDto> getDistinctReportsByMainFeed(int page, int size);

    // void deleteReport(Integer id);
}