package com.mini.framework.dao.bean;

import java.util.List;
import com.mini.framework.core.bean.BaseBean;

/**
 * ��ҳ����
 *
 * @author huangyong
 * @since 1.0
 */
public class Pager<T> extends BaseBean {

    private int pageNumber;     // ҳ����
    private int pageSize;       // ÿҳ����
    private long totalRecord;   // �ܼ�¼��
    private long totalPage;     // ��ҳ����
    private List<T> recordList; // �����б�

    public Pager() {
    }

    public Pager(int pageNumber, int pageSize, long totalRecord, List<T> recordList) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.recordList = recordList;
        if (pageSize != 0) {
            totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;
        }
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public List<T> getRecordList() {
        return recordList;
    }

    // ----------------------------------------------------------------------------------------------------

    public boolean isFirstPage() {
        return pageNumber == 1;
    }

    public boolean isLastPage() {
        return pageNumber == totalPage;
    }

    public boolean isPrevPage() {
        return pageNumber > 1 && pageNumber <= totalPage;
    }

    public boolean isNextPage() {
        return pageNumber < totalPage;
    }
}
