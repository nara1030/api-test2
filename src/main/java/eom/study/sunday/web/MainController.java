package eom.study.sunday.web;

import eom.study.sunday.exception.NoInputDataException;
import eom.study.sunday.request.RequestVo;
import eom.study.sunday.response.ErrorCode;
import eom.study.sunday.response.Result;
import eom.study.sunday.util.CustomFilter;
import eom.study.sunday.util.CustomPrint;
import eom.study.sunday.util.CustomSorter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MainController {

    /**
     * GET REST API
     *
     * @param
     * @return
     * @exception
     */
    @GetMapping("/api")
    public Result parseDataByGetMethod(@Valid RequestVo requestVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new NoInputDataException(ErrorCode.INVALID_INPUT_VALUE, bindingResult);
        }

        String data = requestVo.getUrlData();
        // 필터링/정렬/교차
        String intermediateData = CustomPrint.sortData(CustomSorter.sortData(CustomFilter.filterData(data)));

        return Result.getResult(intermediateData, requestVo.getShare());
    }

    /**
     * POST REST API
     *
     * @param
     * @return
     * @exception
     */
    @PostMapping("/api")
    public Result parseDataByPostMethod(@RequestBody @Valid final RequestVo requestVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new NoInputDataException(ErrorCode.INVALID_INPUT_VALUE, bindingResult);
        }

        String data = requestVo.getUrlData();
        // 필터링/정렬/교차
        String intermediateData = CustomPrint.sortData(CustomSorter.sortData(CustomFilter.filterData(data)));

        return Result.getResult(intermediateData, requestVo.getShare());
    }
}
