// Package client
/*
 * YuanJing OpenAPI SDK for Go
 *
 *
 */
package model

type ConsoleAdminStopGameeResultModel struct {
    GameSession string `json:"GameSession,omitempty"`
    Message string `json:"Message,omitempty"`
    Code string `json:"Code,omitempty"`
    Success bool `json:"Success,omitempty"`
    GameId string `json:"GameId,omitempty"`
}
