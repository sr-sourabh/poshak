FROM node:13.12.0-alpine

WORKDIR /poshak-ui

ENV PATH /poshak-ui/node_modules/.bin:$PATH

COPY package.json ./
COPY package-lock.json ./

COPY . ./

CMD ["npm", "start"]
