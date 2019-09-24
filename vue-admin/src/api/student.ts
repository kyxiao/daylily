import request from '@/utils/request'

export const getfindAll = (params: any) =>
  request({
    url: '/student/findAll',
    method: 'get',
    params
  })