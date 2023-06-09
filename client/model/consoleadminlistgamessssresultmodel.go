// Package client
/*
 * YuanJing OpenAPI SDK for Go
 *
 *
 */
package model

type ConsoleAdminListGamessssResultModel struct {
    DataList []ConsoleAdminListGamessssResultModelDataList `json:"DataList,omitempty"`
    NextToken string `json:"NextToken,omitempty"`
    MsgInfo string `json:"MsgInfo,omitempty"`
    MsgCode string `json:"MsgCode,omitempty"`
    MaxResults int32 `json:"MaxResults,omitempty"`
    Count int32 `json:"Count,omitempty"`
    Success bool `json:"Success,omitempty"`
}
