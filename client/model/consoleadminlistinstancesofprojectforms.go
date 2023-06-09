// Package client
/*
 * YuanJing OpenAPI SDK for Go
 *
 *
 */
package model

type ConsoleAdminListInstancesOfProjectForms struct {
    NextToken *string `json:"nextToken,omitempty"`
    MaxResult string `json:"maxResult"`
    ProjectId string `json:"projectId"`
}
